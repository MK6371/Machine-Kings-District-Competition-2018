import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 300187 on 3/20/2018.
 */
@TeleOp(name = "BaseTest")
public class BaseTest extends OpMode {
    //declare variables in Android Studio
    public float LFspeed;
    public float LBspeed;
    public float RFspeed;
    public float RBspeed;
    public DcMotor motorLF;
    public DcMotor motorLB;
    public DcMotor motorRF;
    public DcMotor motorRB;


    @Override
    public void init() {
    //declare on the phone
    motorLF = hardwareMap.dcMotor.get("motorLF");
    motorRB = hardwareMap.dcMotor.get("motorRB");
    motorLB = hardwareMap.dcMotor.get("motorLB");
    motorRF = hardwareMap.dcMotor.get("motorRF");
    }

    @Override
    public void loop() {
        //
        LFspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
        LBspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
        RFspeed = gamepad1.right_stick_y + gamepad1.right_stick_x;
        RBspeed = gamepad1.right_stick_y - gamepad1.right_stick_x;


        LFspeed = Range.clip(LFspeed, -1,1);
        LBspeed = Range.clip(LBspeed, -1,1);
        RFspeed = Range.clip(RFspeed, -1,1);
        RBspeed = Range.clip(RBspeed, -1,1);


        motorRF.setPower(RFspeed);
        motorLB.setPower(LBspeed);
        motorRB.setPower(RBspeed);
        motorLF.setPower(LFspeed);







    }
}
