import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 300187 on 3/14/2018.
 */
@TeleOp(name = "IntakeTest")
public class IntakeTest extends OpMode {
    //declare your variables for Android Studio
    public CRServo intakeLeft;
    public CRServo intakeRight;
    public Servo topLeft;
    public Servo bottomLeft;
    public Servo topRight;
    public Servo bottomRight;
    public DcMotor lift;

    @Override 
    public void init() {
        //declare on the phone
        intakeLeft = hardwareMap.crservo.get("intakeLeft");
        intakeRight = hardwareMap.crservo.get("intakeRight");
        topLeft = hardwareMap.servo.get("topLeft");
        bottomLeft = hardwareMap.servo.get("bottomRight");
        topRight = hardwareMap.servo.get("topRight");
        bottomRight = hardwareMap.servo.get("bottomRight");
        lift = hardwareMap.dcMotor.get("lift");
    }

    @Override
    public void loop() {
        if(gamepad2.right_bumper){
            intakeLeft.setPower(-1);    //INTAKE
            intakeRight.setPower(1);
        }
else if(gamepad2.left_bumper){
            intakeLeft.setPower(1);     //OUTAKE
            intakeRight.setPower(-1);
        }
else if (gamepad2.a){
            topLeft.setPosition(.7);   //Open Claw
            bottomLeft.setPosition(-.7);
            topRight.setPosition(-.7);
            bottomRight.setPosition(.7);
        }
else if (gamepad2.b){
            topLeft.setPosition(.4);   //Close Claw
            bottomLeft.setPosition(-.4);
            topRight.setPosition(-.4);
            bottomRight.setPosition(.4);
        }
else if (Math.abs(gamepad2.right_trigger)>.1) {
            lift.setPower(1);          //Bring Lift Up
        }
else if (Math.abs(gamepad2.left_trigger)>.1) {
            lift.setPower(-1);         //Bring Lift Right
        }

        else{
    intakeLeft.setPower(0);
    intakeRight.setPower(0);
    lift.setPower(0);
        }
    }
}
