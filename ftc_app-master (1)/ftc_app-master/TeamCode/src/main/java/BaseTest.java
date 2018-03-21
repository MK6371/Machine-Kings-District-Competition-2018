import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by 300187 on 3/20/2018.
 */
@TeleOp(name = "BaseTest")
public class BaseTest extends OpMode {
    //declare variables in Android Studio
    public DcMotor LFspeed;
    public DcMotor LBspeed;
    public DcMotor RFspeed;
    public DcMotor RBspeed;

    @Override
    public void init() {
    LFspeed = hardwareMap.dcMotor.get("LFspeed");
    LBspeed = hardwareMap.dcMotor.get("LBspeed");
    RFspeed = hardwareMap.dcMotor.get("RFspeed");
    RBspeed = hardwareMap.dcMotor.get("RBspeed");
    }

    @Override
    public void loop() {
        float LFspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
        float LRspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
        float BFspeed = gamepad1.right_stick_y + gamepad1.right_stick_x;
        float BRspeed = gamepad1.right_stick_y - gamepad1.right_stick_x;


    }
}
