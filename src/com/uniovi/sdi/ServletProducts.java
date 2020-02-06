package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProducts
 */
@WebServlet("/ServletProducts")
public class ServletProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Producto> productosTienda;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducts() {
        super();
        productosTienda = (List<Producto>) new ProductosService().getProductos();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", productosTienda);
		
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
