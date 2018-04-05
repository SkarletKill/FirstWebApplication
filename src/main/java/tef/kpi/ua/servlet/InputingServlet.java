package tef.kpi.ua.servlet;

import tef.kpi.ua.controller.InputRecord;
import tef.kpi.ua.model.Model;
import tef.kpi.ua.model.SuchLoginExistsException;
import tef.kpi.ua.view.View;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputingServlet extends HttpServlet {
    private static String NAME = "name";
    private static String EMAIL = "email";
    private static String LOGIN = "login";

    private static String OLD_EMAIL = "oldemail";
    private static String OLD_NAME = "oldname";
    private static String OLD_LOGIN = "oldlogin";
    private static String ERROR_MESSAGE = "errorMsg";
    private static String index = "index.jsp";
    private static String congrats = "congrats.jsp";
    private final static int MINIMUM_ERR_MSG_LENGTH = 2;
    private String errorMessage = "";
    private boolean modelInitialised = false;

    private InputRecord inputRecord;
    private Model model;

    @Override
    public void init() {
        this.model = new Model();
        this.inputRecord = new InputRecord();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter(NAME);
        String username = request.getParameter(LOGIN);
        String email = request.getParameter(EMAIL);

        inputRecord.setInputNoteData(name, email, username);
        inputRecord.processInput();
        processData(inputRecord, request, response);

        doGet(request, response);

//        PrintWriter out = response.getWriter();
//        out.println("<h3>Hello from:</h3><br>" + name + "<br>" + username + "<br>" + email);
//        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (modelInitialised) {

            request.setAttribute(NAME, model.getRecord().getName());
            request.setAttribute(EMAIL, model.getRecord().getEmail());
            request.setAttribute(LOGIN, model.getRecord().getNickname());
            request.getRequestDispatcher(congrats).forward(request, response);
        } else {
            if (errorMessage.length() > MINIMUM_ERR_MSG_LENGTH) {
                request.setAttribute(ERROR_MESSAGE, errorMessage);
                errorMessage = "";
            }
            request.setAttribute(OLD_NAME, inputRecord.getInputRecord().getName());
            request.setAttribute(OLD_EMAIL, inputRecord.getInputRecord().getEmail());
            request.setAttribute(OLD_LOGIN, inputRecord.getInputRecord().getNickname());
            request.getRequestDispatcher(index).forward(request, response);
        }
    }

    private void processData(InputRecord inputRecord, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (!inputRecord.isCorrect()) {
            errorMessage = inputRecord.getErrorMessage();
            doGet(req, resp);
        } else {
            try {
                model.setRecord(inputRecord.getInputRecord());
            } catch (SuchLoginExistsException err) {
                errorMessage = View.concatenationStrings(
                        View.getLocaleMassage(View.INPUT_NICKNAME),
                        err.getWrongData().getNickname(),
                        View.getLocaleMassage(View.INPUT_NICKNAME_EXIST
                        ));
                doGet(req, resp);
            }
            modelInitialised = true;
        }
    }
}
