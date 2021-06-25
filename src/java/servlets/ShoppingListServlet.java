/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 840288
 */
public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) session.getAttribute("username");

        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            String message = "Successfully logged out";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        if (username != null) {
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String action = request.getParameter("action");
        
        if (username != null) {
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
        }
        if (session.getAttribute("items") == null) {
            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("items", items);
        }
        else if (action.equals("add")) {
            ArrayList<String> items;
            items = (ArrayList<String>) session.getAttribute("items");
            String item = request.getParameter("addItem");
            items.add(item);
            request.setAttribute("items", items);
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else if (action.equals("delete")) {
            ArrayList<String> items;
            items = (ArrayList<String>) session.getAttribute("items");
            String item = request.getParameter("deleteItem");
            items.remove(item);
            request.setAttribute("items", items);
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }
}
