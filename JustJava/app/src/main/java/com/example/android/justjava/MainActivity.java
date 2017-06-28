
/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.search);
        String str = text.getText().toString();
        Log.v("name: ", str);
        boolean whipped_cream_check, chocolate_check;
        CheckBox whipped_cream = (CheckBox) findViewById(R.id.checkbox_whipped_cream_view);
        CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox_chocolate_view);
        whipped_cream_check = whipped_cream.isChecked();
        chocolate_check = chocolate.isChecked();
        int price = calculatePrice(quantity, whipped_cream_check, chocolate_check);
        displayMessage(createOrderSummary(str, price, whipped_cream_check, chocolate_check));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view){
        if(quantity < 100) {
            quantity = quantity + 1;
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
        if(quantity > 0) {
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(boolean add_whipped_cream, boolean add_chocolate, int quantity) {
        int cost = 5;
        if(add_whipped_cream)
        {
            cost += 1;
        }
        if(add_chocolate)
        {
            cost += 2;
        }
        return quantity * cost;
    }

    /**
     * Creates an order summary.
     *
     * @param price is the cost of coffee cups
     * @return summary
     */

    private String createOrderSummary(String name, int price, boolean whipped_cream, boolean chocolate)
    {
        return "Name: " + name + "\nAdd whipped cream? " + whipped_cream + "\nAdd chocolate? " + chocolate + "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank you!";
    }
}