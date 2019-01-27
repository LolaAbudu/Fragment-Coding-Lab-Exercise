package com.example.android.FragmentExample1;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.android.fragmentexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;
    RatingBar ratingBar;

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView =
         inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        ratingBar = rootView.findViewById(R.id.radio_group_ratingBar);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView =
                        rootView.findViewById(R.id.fragment_header);
                switch (index) {
                    case YES: // User chose "Yes."
                        textView.setText(R.string.yes_message);
                        break;
                        case NO: // User chose "No."
                            textView.setText(R.string.no_message);
                            break;
                            default: // No choice made.
                                // Do nothing.
                                break;
                }
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (ratingBar.getRating() == 0 ) {
                    Toast.makeText(getActivity(), "You rated 0", Toast.LENGTH_LONG).show();
                    //Snackbar.make(view, getResources().getString(R.string.no_review), Snackbar.LENGTH_LONG).show();
                } else if (ratingBar.getRating() == 1){
                    Toast.makeText(getActivity(), "You rated 1", Toast.LENGTH_LONG).show();
//                    reviewService.addDishesReview(reviews);
//                    reviewService.addRestaurantReview(orderService.getRestaurantId(order.getId()),
//                            ratingBar.getRating(), comment.getText().toString());
//                    reviewService.deleteOrderToReview(order.getId());
//                    finish();
                }
            }
        });
        return rootView;
    }
}
