import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by 300187 on 3/15/2018.
 */
@Disabled
@TeleOp(name = "BaseMovement")
public class BaseMovement extends OpMode{
    //Declare Mecanum Wheels
    public DcMotor FLWheel;
    public DcMotor FRWheel;
    public DcMotor BLWheel;
    public DcMotor BRWheel;
    @Override
    public void init() {
       FLWheel = hardwareMap.dcMotor.get("FLWheel");
       FRWheel = hardwareMap.dcMotor.get("FRWheel");
       BLWheel = hardwareMap.dcMotor.get("BLWheel");
       BRWheel = hardwareMap.dcMotor.get("BRWheel");
    }

    @Override
    public void loop() {
        if(gamepad1.right_stick_y > .1)
        { //Movement Foward
            FRWheel.setPower(gamepad1.right_stick_y);
            BRWheel.setPower(gamepad1.right_stick_y);
        }
        else
        {
            FRWheel.setPower(0);
            BRWheel.setPower(0);
        }
}
    {
        if(gamepad1.left_stick_y > .1)
        { //Movement Foward
            FLWheel.setPower(gamepad1.left_stick_y);
            BLWheel.setPower(gamepad1.left_stick_y);
        }
        else
        {
            FLWheel.setPower(0);
            BLWheel .setPower(0);
        }
    }
}
