package ru.own.www.logic;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

import admin.ru.own.www.entity.Category;
import admin.ru.own.www.entity.CategoryClientShow;
import admin.ru.own.www.mybatis.dao.CategoryDAOImp;
import admin.ru.own.www.mybatis.dao.CategoryMapper;

/**  
 * This class is used for ...  
 * @author jingquanliang,
 * @version 1.0, 
 * @data 2014年12月8日 下午3:03:22  
 */
public class CategoryOperate extends ActionSupport implements SessionAware
{
	private Map session;  
	
	List<CategoryClientShow> ccs;

	List banner;

	public String getShowCategory()
	{
		int lanid=Integer.parseInt((String) session.get("languageId"));
		
		CategoryMapper categoryDAO = new CategoryDAOImp();
		ccs= categoryDAO.getShowCategory(lanid);
		banner = categoryDAO.getBannerShowCategory(lanid);
		categoryDAO.closeSession();
//		System.out.println("++++++++++++++++++++++++++++++++++");
		if(ccs!=null)
		{
//			System.out.println("成功的得到了分类");
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}


	public List getCcs()
	{
		return ccs;
	}

	public void setCcs(List ccs)
	{
		this.ccs = ccs;
	}

	public void setSession(Map session)
	{
		this.session = session;
	}

	public List getBanner()
	{
		return banner;
	}

	public void setBanner(List banner)
	{
		this.banner = banner;
	}

}
