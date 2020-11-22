package kw.raport.model.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kw.raport.model.raportData.owner.EntryBasis;

/**
 * Servlet implementation class ChooseMapInfoServletTest
 */
@WebServlet("/ChooseMapInfoServletTest")
public class ChooseMapInfoServletTest extends HttpServlet {


	private static final long serialVersionUID = 378280910392484977L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseMapInfoServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	List<EntryBasis> itemsList = new ArrayList<EntryBasis>();
		itemsList.add(new EntryBasis("Opcja pierwsza"));
		itemsList.add(new EntryBasis("Opcja druga"));
		itemsList.add(new EntryBasis("Opcja trzecia"));
		itemsList.add(new EntryBasis("Opcja pierwsza"));
		itemsList.add(new EntryBasis("Opcja druga"));
		itemsList.add(new EntryBasis("Opcja trzecia"));
		request.setAttribute("itemsList", itemsList);

		request.getRequestDispatcher("/chooseMapInfo.jsp").forward(request, response);
		
	}

}
