    package jbbellot.ysu.KmapApp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final CellArray kMap;
    private EditText display;


    public  MainActivity() {
        super();
        kMap =  new CellArray();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kMap.InitializeCells();
        display = this.findViewById(R.id.editTextTextMultiLine);


        Button buttonOne = this.findViewById(R.id.button1);
        Button buttonTwo = this.findViewById(R.id.button2);
        Button buttonThree = this.findViewById(R.id.button3);
        Button buttonFour = this.findViewById(R.id.button4);
        Button buttonFive = this.findViewById(R.id.button5);
        Button buttonSix = this.findViewById(R.id.button6);
        Button buttonSeven = this.findViewById(R.id.button7);
        Button buttonEight = this.findViewById(R.id.button8);
        Button buttonNine = this.findViewById(R.id.button9);
        Button buttonTen = this.findViewById(R.id.button10);
        Button buttonEleven = this.findViewById(R.id.button11);
        Button buttonTwelve = this.findViewById(R.id.button12);
        Button buttonThirteen = this.findViewById(R.id.button13);
        Button buttonFourteen = this.findViewById(R.id.button14);
        Button buttonFifteen = this.findViewById(R.id.button15);
        Button buttonSixteen = this.findViewById(R.id.button16);

        buttonOne.setText("0");buttonTwo.setText("0");buttonThree.setText("0");buttonFour.setText("0");
        buttonFive.setText("0");buttonSix.setText("0");buttonSeven.setText("0");buttonEight.setText("0");
        buttonNine.setText("0");buttonTen.setText("0");buttonEleven.setText("0");buttonTwelve.setText("0");
        buttonThirteen.setText("0");buttonFourteen.setText("0");buttonFifteen.setText("0");buttonSixteen.setText("0");


        buttonOne.setOnClickListener(view ->{
            kMap.changeValue(true,0,0);
            buttonOne.setText("1");
        });

        buttonTwo.setOnClickListener(view ->{
            kMap.changeValue(true,1,0);
            buttonTwo.setText("1");
        });

        buttonThree.setOnClickListener(view ->{
            kMap.changeValue(true,2,0);
            buttonThree.setText("1");
        });

        buttonFour.setOnClickListener(view ->{
            kMap.changeValue(true,3,0);
            buttonFour.setText("1");
        });



        buttonFive.setOnClickListener(view ->{
            kMap.changeValue(true,0,1);
            buttonFive.setText("1");
        });

        buttonSix.setOnClickListener(view ->{
            kMap.changeValue(true,1,1);
            buttonSix.setText("1");
        });

        buttonSeven.setOnClickListener(view ->{
            kMap.changeValue(true,2,1);
            buttonSeven.setText("1");
        });

        buttonEight.setOnClickListener(view ->{
            kMap.changeValue(true,3,1);
            buttonEight.setText("1");
        });



        buttonNine.setOnClickListener(view ->{
            kMap.changeValue(true,0,2);
            buttonNine.setText("1");
        });

        buttonTen.setOnClickListener(view ->{
            kMap.changeValue(true,1,2);
            buttonTen.setText("1");
        });

        buttonEleven.setOnClickListener(view ->{
            kMap.changeValue(true,2,2);
            buttonEleven.setText("1");
        });

        buttonTwelve.setOnClickListener(view ->{
            kMap.changeValue(true,3,2);
            buttonTwelve.setText("1");
        });



        buttonThirteen.setOnClickListener(view ->{
            kMap.changeValue(true,0,3);
            buttonThirteen.setText("1");
        });

        buttonFourteen.setOnClickListener(view ->{
            kMap.changeValue(true,1,3);
            buttonFourteen.setText("1");
        });

        buttonFifteen.setOnClickListener(view ->{
            kMap.changeValue(true,2,3);
            buttonFifteen.setText("1");
        });

        buttonSixteen.setOnClickListener(view ->{
            kMap.changeValue(true,3,3);
            buttonSixteen.setText("1");
        });




        Button solveButton = this.findViewById(R.id.SolveButton);
        solveButton.setOnClickListener(view ->{
            kMap.findQuads();
            kMap.findSquares();
            kMap.findDoubles();
            kMap.findSingles();

            kMap.simplifyExpression(GroupType.Quad);
            kMap.simplifyExpression(GroupType.Square);
            kMap.simplifyExpression(GroupType.Double);
            kMap.simplifyExpression(GroupType.Single);

            display.setText(kMap.returnExpression());


        });

        ImageButton resetButton = this.findViewById(R.id.ResetButton);
        resetButton.setOnClickListener(view ->{
            kMap.reset();
            display.setText(kMap.returnExpression());
            buttonOne.setText("0"); buttonTwo.setText("0"); buttonThree.setText("0"); buttonFour.setText("0");
            buttonFive.setText("0"); buttonSix.setText("0"); buttonSeven.setText("0"); buttonEight.setText("0");
            buttonNine.setText("0"); buttonTen.setText("0");buttonEleven.setText("0");buttonTwelve.setText("0");
            buttonThirteen.setText("0");buttonFourteen.setText("0");buttonFifteen.setText("0");buttonSixteen.setText("0");

        });

    }



}

