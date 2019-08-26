package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

public class CartServlet extends HttpServlet {

	// ��ʾ���ﳵ�Ķ��� ,add,show,delete
	private String action;
	// ��Ʒҵ���߼���Ķ���
	private ItemsDAO idao = new ItemsDAO();

	public CartServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
	//��дdoGet()��doPost()����
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//�жϹ��ﳵ�Ķ���
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			//�����������Ʒ�����ﳵ
			if (action.equals("add")) 
			{
				if (addToCart(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			//�������ʾ���ﳵ����ת�����ﳵҳ�棩
			if (action.equals("show"))
			{
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			//�����ִ��ɾ�����ﳵ�е���Ʒ
			if (action.equals("delete")) 
			{
				if (deleteFromCart(request, response)) {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}

	}

	// ������Ʒ�����ﳵ�ķ���
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String number = request.getParameter("num");
		Items item = idao.getItemsById(Integer.parseInt(id));

		//����ǵ�һ�θ����ﳵ������Ʒ,��Ҫ��session�д���һ���µĹ��ﳵ����
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			return true;
		} else {
			return false;
		}

	}

	// �ӹ��ﳵ��ɾ����Ʒ
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		Items item = idao.getItemsById(Integer.parseInt(id));
		if (cart.removeGoodsFromCart(item)) {
			return true;
		} else {
			return false;
		}
	}
	//��ʼ������
	public void init() throws ServletException {
	}

}