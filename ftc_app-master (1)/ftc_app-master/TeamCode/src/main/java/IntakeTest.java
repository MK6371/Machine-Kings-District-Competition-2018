import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

/**
 * Created by 300187 on 3/14/2018.
 */
@TeleOp(name = "IntakeTest")
public class IntakeTest extends OpMode {
    //declare your variables for Android Studio
    public CRServo intakeLeft;
    public CRServo intakeRight;

    @Override 
    public void init() {
        //declare on the phone
        intakeLeft = hardwareMap.crservo.get("intakeLeft");
        intakeRight = hardwareMap.crservo.get("intakeRight");
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
        else{
    intakeLeft.setPower(0);
    intakeRight.setPower(0);
        }
    }
}
