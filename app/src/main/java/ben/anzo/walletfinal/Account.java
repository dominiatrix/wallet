package ben.anzo.walletfinal;

import java.util.Date;

public class Account {
    String money;
    String accounttype;

    public String getLogo() {
        return logo;
    }

    String logo;


    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Account(String accounttype,String money, String date,String logo) {
        this.money = money;
        this.accounttype = accounttype;
        this.date = date;
        this.logo = logo;
    }

    String date;



}
