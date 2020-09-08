package org.cskj.boot.goods.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.cskj.boot.goods.bean.Goods;
import org.cskj.boot.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

	@Autowired
	private GoodsService gs;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/*
	 * restful风格
	 * get查询
	 * post添加
	 * put修改
	 * delete删除
	 */
	
	@GetMapping(value="queryGoodsAll")
	public List<Goods> queryGoodsAll(){
		return gs.queryGoodsAll();
	}
	
	@PostMapping(value="addGoods")
	public boolean addGoods(@RequestBody Goods goods) throws ParseException {
		Date parse = sdf.parse(goods.getCreateDate());
		goods.setCreateDate(sdf.format(parse));
		return gs.addGoods(goods) > 0 ? true : false;
	}
	
	@DeleteMapping(value="deleteGoods")
	public boolean deleteGoods(int id) {
		return gs.deleteGoods(id) > 0 ? true : false;
	}
	
	@PostMapping(value="queryGoodsById")
	public Goods queryGoodsById(@RequestBody Goods goods) {
		System.out.println("123456");
		return gs.queryGoodsById(goods);
	}
	
	@PutMapping(value="updateGoods")
	public boolean updateGoods(@RequestBody Goods goods) throws ParseException {
		System.out.println(goods);
		Date parse = sdf.parse(goods.getCreateDate());
		goods.setCreateDate(sdf.format(parse));
		return gs.updateGoods(goods) > 0 ? true : false;
	}
}
