package ru.netology.servlet;

import ru.netology.controller.PostController;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    private PostController controller;

    @Override
    public void init() {
        final var repository = new PostRepository();
        final var service = new PostService(repository);
        controller = new PostController(service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html,charset=UTF-8");
        var path = req.getRequestURI();
        if (path.matches("/api/posts/\\d+")) {
            final var id = Long.parseLong(path.substring(path.lastIndexOf("/") + 1));
            resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            resp.getWriter().println("Был обработан Get-запрос и искал пост по id = " + id + " \n");
            controller.getById(id, resp);
        } else if (path.matches("/api/posts")) {
            resp.getWriter().println("Был обработан Get-запрос и получен список всех постов: \n");
            controller.all(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html,charset=UTF-8");
        resp.getWriter().println("Был обработан Post-запрос \n");
        controller.save(req.getReader(), resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html,charset=UTF-8");
        var path = req.getRequestURI();
        resp.getWriter().println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        final var id = Long.parseLong(path.substring(path.lastIndexOf("/") + 1));
        resp.getWriter().println("Был обработан Delete-запрос \n");
        controller.removeById(id, resp);
    }

}