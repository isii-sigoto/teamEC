package jp.co.internous.team2507.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.team2507.model.domain.MstCategory;
import jp.co.internous.team2507.model.domain.MstProduct;
import jp.co.internous.team2507.model.form.SearchForm;
import jp.co.internous.team2507.model.mapper.MstCategoryMapper;
import jp.co.internous.team2507.model.mapper.MstProductMapper;
import jp.co.internous.team2507.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/team2507")
public class IndexController {	
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired 
    private LoginSession loginSession;
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		if (!loginSession.isLoggedIn() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = new Random().nextInt(1_000_000_000);
			tmpUserId *= -1;
			loginSession.setTmpUserId(tmpUserId);
		}
		
		List<MstCategory> categories = categoryMapper.find();
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("categories",categories);
		m.addAttribute("products",products);
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
	
	/**
	 * 検索処理を行う
	 * @param f 検索用フォーム
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {

		String keywords = f.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		String[] keywordList = keywords.split(" ");
		List<MstProduct> products = new ArrayList<>();
		
		if (f.getCategory() == 0) {
			products = productMapper.findByProductName(keywordList);
		} else {
			products = productMapper.findByCategoryAndProductName(f.getCategory(), keywordList);
		}
		
		m.addAttribute("products", products);
		m.addAttribute("keywords", keywords);
		m.addAttribute("selected", f.getCategory());
		
		List<MstCategory> categories = categoryMapper.find();
		m.addAttribute("categories", categories);
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
}
