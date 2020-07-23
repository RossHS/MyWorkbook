package designPatterns.structural.adapter;

/**
 * во что нам следует адаптировать Xpay
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public interface PayD {
     String getCustCardNo();

     String getCardOwnerName();

     String getCardExpMonthDate();

     Integer getCVVNo();

     Double getTotalAmount();

     void setCustCardNo(String custCardNo);

     void setCardOwnerName(String cardOwnerName);

     void setCardExpMonthDate(String cardExpMonthDate);

     void setCVVNo(Integer cVVNo);

     void setTotalAmount(Double totalAmount);
}
