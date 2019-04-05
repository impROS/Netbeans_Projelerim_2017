/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinveri;

public class Koineks {

    private String short_code, name, currency, current, change_amount, change_percentage, high, low, volume, ask, bid, timestamp;

    public String getShort_code() {
        return short_code;
    }

    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getCurrent() {
        return Float.parseFloat(current);
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getChange_amount() {
        return change_amount;
    }

    public void setChange_amount(String change_amount) {
        this.change_amount = change_amount;
    }

    public String getChange_percentage() {
        return change_percentage;
    }

    public void setChange_percentage(String change_percentage) {
        this.change_percentage = change_percentage;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
