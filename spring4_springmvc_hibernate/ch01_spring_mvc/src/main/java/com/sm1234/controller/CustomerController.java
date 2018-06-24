package com.sm1234.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.sm1234.domain.Customer;
import com.sm1234.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	/**
	 * 用于跳转到save.jsp页面
	 */
	@RequestMapping("/saveUI")
	public String saveUI(){
		return "save";
	}
	
	@Resource
	private CustomerService customerService;
	
	/**
	 * 添加客户
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String save(Customer customer, Map<String,Object> model){
		customerService.save(customer);
		//保存提示信息
		model.put("msg", "添加成功");
		return "success";
	}
	
	/**
	 * 查询所有客户
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String list(Map<String,Object> model){
		List<Customer> custList = customerService.findAll();
		model.put("custList", custList);
		return "list";
	}
	
	/**
	 * 查询一个客户
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String findById(@PathVariable("id")Long custId,Map<String,Object> model){
		Customer cust = customerService.findById(custId);
		model.put("cust", cust);
		return "edit";
	}
	
	/**
	 * 客户修改
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public String update(Customer customer,Map<String,Object> model){
		customerService.update(customer);
		model.put("msg", "修改成功");
		return "success";
	}
	
	/**
	 * 删除客户
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	public String delete(Long[] custIds,Map<String,Object> model){
		customerService.delete(custIds);
		model.put("msg", "删除成功");
		return "success";
	}
}
