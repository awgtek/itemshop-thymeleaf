package com.awgtek.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.awgtek.domain.ShopItem;
import com.awgtek.service.ShopItemServiceInterface;

@Controller
public class ShopItemController {

	@Autowired
	ShopItemServiceInterface shopItemServiceInterface;
	

	@RequestMapping(value = {"/","/savepage"}, method = RequestMethod.GET)
	public String savePage(Model model) {
		model.addAttribute("shopItem", new ShopItem());
		model.addAttribute("allShopItems", (ArrayList<ShopItem>)shopItemServiceInterface.getAllShopItems());
		return "index";
	}
	
	@RequestMapping(value = {"/shopItem/save"}, method = RequestMethod.POST)
	public String saveShopItem(@ModelAttribute("shopItem") ShopItem shopItem,
			final RedirectAttributes redirectAttributes) {
		
		if(shopItemServiceInterface.saveShopItem(shopItem)!=null) {
			redirectAttributes.addFlashAttribute("saveShopItem", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveShopItem", "unsuccess");
		}
		
		return "redirect:/savepage";
	}
	
	@RequestMapping(value = "/shopItem/{operation}/{shopItemId}", method = RequestMethod.GET)
	public String editRemoveShopItem(@PathVariable("operation") String operation,
			@PathVariable("shopItemId") Integer shopItemId, final RedirectAttributes redirectAttributes,
			Model model) {
		if(operation.equals("increment")) {
			if(shopItemServiceInterface.incrementPriorityOfShopItem(shopItemId)) {
				redirectAttributes.addFlashAttribute("increment", "success");
			} else {
				redirectAttributes.addFlashAttribute("increment", "unsuccess");
			}
		} else if(operation.equals("decrement")) {
			if(shopItemServiceInterface.decrementPriorityOfShopItem(shopItemId)) {
				redirectAttributes.addFlashAttribute("decrement", "success");
			} else {
				redirectAttributes.addFlashAttribute("decrement", "unsuccess");
			}
		} else if(operation.equals("delete")) {
			if(shopItemServiceInterface.deleteShopItem(shopItemId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if(operation.equals("edit")){
		  ShopItem editShopItem = shopItemServiceInterface.findShopItem(shopItemId);
		  if(editShopItem!=null) {
		       model.addAttribute("editShopItem", editShopItem);
		       return "editPage";
		  } else {
			  redirectAttributes.addFlashAttribute("status","notfound");
		  }
		}
		
		return "redirect:/savepage";
	}
	
	@RequestMapping(value = "/shopItem/update", method = RequestMethod.POST)
	public String updateShopItem(@ModelAttribute("editShopItem") ShopItem editShopItem,
			final RedirectAttributes redirectAttributes) {
		if(shopItemServiceInterface.editShopItem(editShopItem)!=null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/savepage";
	}
}
