package pru.spt.data.model;

import com.google.gson.JsonObject;

import pru.spt.misc.AppConstant;
import pru.test.data.JsonValueReader;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;


public class EclientAppData {
	private JsonValueReader jsonValueReader;

	
	//REGISTRATION DATA
	public JsonObject registrationJsonObj;
	
	//COMPUTER PRODUCTS DATA
	public JsonObject computerJsonObj;
	public JsonObject ProductlistJsonObj;
	public String[] optionsArray;
	public JsonObject dellJsonObj;
	public JsonObject vanquishJsonObj;
	public JsonObject lenovoJsonObj;
	
	
	//calling constructor
	public EclientAppData(JsonValueReader jsonValueReader) {
		this.jsonValueReader = jsonValueReader;
		this.getRegistrationJson();
		this.getComputerJson();
		// this.getLoginJson(); // Commented out, not implemented
	}
	
	
	//Methods to get JsonObjects
	public void getRegistrationJson() {
		registrationJsonObj = jsonValueReader.getJsonObject("Registration");
	}
	
	//Methods to get Products Data
	public void getComputerJson() {
		computerJsonObj = jsonValueReader.getJsonObject("Computers");
		ProductlistJsonObj = computerJsonObj.getAsJsonObject("Productlist");
		
		optionsArray = ProductlistJsonObj.has("optionsArray")? JsonToArrayofString(ProductlistJsonObj.getAsJsonArray("optionsArray")): null;
        
        dellJsonObj = ProductlistJsonObj.has("Dell")? ProductlistJsonObj.getAsJsonObject("Dell"): null;
        
//      if(dellJsonObj!=null) {
//          delladdtocartJsonObj = dellJsonObj.getAsJsonObject("addtoCart");
//          delladdtocomparelistJsonObj = dellJsonObj.getAsJsonObject("addtoCompareList");
//          delladdtowishlistJsonObj = dellJsonObj.getAsJsonObject("addtoWishList");
//          
//      }
        
        vanquishJsonObj = ProductlistJsonObj.has("Vanquish")? ProductlistJsonObj.getAsJsonObject("Vanquish"): null;
        
//      if(vanquishJsonObj!=null) {
//          vanquishaddtocartJsonObj = vanquishJsonObj.getAsJsonObject("addtoCart");
//          vanquishaddtocomparelistJsonObj = vanquishJsonObj.getAsJsonObject("addtoCompareList");
//          vanquishaddtowishlistJsonObj = vanquishJsonObj.getAsJsonObject("addtoWishList");
//          
//      }
//      
        
        lenovoJsonObj = ProductlistJsonObj.has("Lenovo")? ProductlistJsonObj.getAsJsonObject("Lenovo"): null;
        
//      if(lenovoJsonObj!=null) {
//          lenovoaddtocartJsonObj = lenovoJsonObj.getAsJsonObject("addtoCart");
//          lenovoaddtocomparelistJsonObj = lenovoJsonObj.getAsJsonObject("addtoCompareList");
//          lenovoaddtowishlistJsonObj = lenovoJsonObj.getAsJsonObject("addtoWishList");
//          
//      }
		
		
	}
	
	
	
	//Methods to get Registration Data
	
	public String getGender() {
		return registrationJsonObj.get("gender").getAsString();
	}

	public String getFirstName() {
		return registrationJsonObj.get("firstName").getAsString();
	}

	public String getLastName() {
		return registrationJsonObj.get("lastName").getAsString();
	}

	public String getEmail() {
		return registrationJsonObj.get("email").getAsString();
	}

	public String getCompanyName() {
		return registrationJsonObj.get("companyName").getAsString();
	}

	public String getnewLetter() {
		return registrationJsonObj.get("newsLetter").getAsString();
	}

	public String getPassword() {
		return registrationJsonObj.get("password").getAsString();
	}
	
	public String getConfirmPassword() {
		return registrationJsonObj.get("confirmPassword").getAsString();
	}
	
	
	//methods to get Computers data
	
	public String getProduct() {
		return ProductlistJsonObj.get("Product").getAsString();
	}

	//methods to get Dell Product data
	public String getDell() {
		return dellJsonObj.get("dell").getAsString();
	}
	
	
	public String getDellAddToCart() {
		return dellJsonObj.get("addtoCart").getAsString();
	}
	public String getDellAddToCompareList() {
		return dellJsonObj.get("addtoCompareList").getAsString();
	}
	public String getDellAddToWishList() {
		return dellJsonObj.get("addtoWishList").getAsString();
	}

	
	
	
	//methods to get vanquish Product data
	
//	public String getVanquish() {
//		return vanquishJsonObj.get("dell").getAsString();
//	}
	
		public String getvanquishAddToCart() {
			return vanquishJsonObj.get("addtoCart").getAsString();
		}
		public String getvanquishAddToCompareList() {
			return vanquishJsonObj.get("addtoCompareList").getAsString();
		}
		public String getvanquishAddToWishList() {
			return vanquishJsonObj.get("addtoWishList").getAsString();
		}
		
	
		//methods to get lenovo Product data
				public String getlenovoAddToCart() {
					return lenovoJsonObj.get("addtoCart").getAsString();
				}
				public String getlenovoAddToCompareList() {
					return lenovoJsonObj.get("addtoCompareList").getAsString();
				}
				public String getlenovoAddToWishList() {
					return lenovoJsonObj.get("addtoWishList").getAsString();
				}
				
				
				
				
				
	
	//Method to convert JsonArray to String Array
	public static String[] JsonToArrayofString(JsonArray jsonArray) {
	    List<String> list = new ArrayList<>();
	    for (JsonElement jsonValue : jsonArray) {
	        String str = jsonValue.toString();
	        str = str.replaceAll("^\"|\"$", "");
	        list.add(str);
	    }
	    return list.stream().toArray(String[]::new);
	}

	public static String nullCheck(JsonObject obj, String Key) {
	    return obj != null ? obj.has(Key)
	        ? obj.getAsString()
	        : AppConstant.EMPTY_STRING : AppConstant.EMPTY_STRING;
	}



}