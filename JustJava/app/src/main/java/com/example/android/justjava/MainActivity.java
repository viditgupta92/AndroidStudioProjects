/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        int price = calculatePrice(whipped_cream_check, chocolate_check, quantity);
//        displayMessage(createOrderSummary(str, price, whipped_cream_check, chocolate_check));
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, ("vidit92.gupta@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(str, price, whipped_cream_check, chocolate_check));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
        if(quantity == 100) {
            Toast.makeText(this, "Number of cups of coffee cannot exceed 100", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
        if(quantity == 1) {
            Toast.makeText(this, "Number of cups of coffee cannot decrease below 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
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
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\nAdd whipped cream? " + whipped_cream + "\nAdd chocolate? " + chocolate + "\nQuantity: " + quantity + "\nTotal: $" + price;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;

    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}