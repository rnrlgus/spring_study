package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {


    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // redirect랑은 좀 다름. 서버 내부끼리 호출하는 것
        // 외부에서 직접적으로 호출하는 것을 원치 않을 때 (컨트롤러를 통해서만 호출되도록) 사용 (WEB-INF)
        dispatcher.forward(request, response);
    }
}
