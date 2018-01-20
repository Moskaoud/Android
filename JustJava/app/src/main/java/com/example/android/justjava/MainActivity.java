package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

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
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        if (quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(this,getString(R.string.toastCannotGetMore), Toast.LENGTH_SHORT).show();
        } else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {


        if (quantity == 1) {
            // Show an error message as a toast
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, getString(R.string.toastCannotGetLess), Toast.LENGTH_SHORT);
            toast.show();
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);

        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText editText = (EditText) findViewById(R.id.name_field);
        String name = editText.getText().toString();
        // Figure out if the user wants whipped cream topping
        CheckBox checkBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = checkBox.isChecked();

        // Figure out if the user wants whipped cream topping
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();

        // Calculate the price
        int price = calculatePrice(hasChocolate, hasWhippedCream);

        // Display order summary on the screen
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);

        // implicit intent for sending mail
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject,name));// Set subject name of app
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * Calculates the price of the order.
     *
     * @param chocolate    if customer add chocolate
     * @param whippedCream if added whippedcream
     * @return total price
     */
    private int calculatePrice(boolean chocolate, boolean whippedCream) {
        int basePrice = 5;

        if (chocolate)
            basePrice += 2;
        if (whippedCream)
            basePrice += 1;

        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param price           of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate    is whether or not the user wants chocolate topping
     * @param name            get customer name
     * @return text summary
     */
    public String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {


        String message = getString(R.string.order_summary_name," "+name)+"\n" ;
        message += getString(R.string.order_summary_whipped_cream,addWhippedCream) +"\n" ;
        message += getString(R.string.order_summary_chocolate,addChocolate)+"\n" ;
        message += getString(R.string.order_summary_quantity, quantity)+"\n" ;
        message += getString(R.string.order_summary_price,NumberFormat.getInstance().format(calculatePrice(addChocolate, addWhippedCream)))+"\n" ;
        message += getString(R.string.thank_you);
        return message;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}