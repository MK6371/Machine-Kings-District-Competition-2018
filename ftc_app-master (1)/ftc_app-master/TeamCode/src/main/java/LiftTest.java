import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by 300187 on 3/21/2018.
 */
@TeleOp (name = "LiftTest")
public class LiftTest extends OpMode{
    //declare variables on Android
    public DcMotor lift;

    @Override
    public void init() {
     //declare on the phone
    lift = hardwareMap.dcMotor.get("lift");

    }

    @Override
    public void loop() {


    }
}
