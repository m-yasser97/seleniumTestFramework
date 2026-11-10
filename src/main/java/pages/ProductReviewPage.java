package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxtbox;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTextTxtbox;
	
	@FindBy(id="addproductrating_5")
	WebElement ratingnum;
	
	@FindBy(id="add-review")
	WebElement submitReviewBtn;
	
	@FindBy(id="p.content")
	public WebElement successMessage;
	
	public void AddProductReview(String reviewTitle, String reviewText)
	{
		setTextElementText(reviewTitleTxtbox, reviewTitle);
		setTextElementText(reviewTextTxtbox, reviewText);
		clickButton(ratingnum);
		clickButton(submitReviewBtn);
	}
}
