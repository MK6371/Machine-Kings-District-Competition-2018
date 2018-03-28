import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name = "FinishedProduct")
public class FinishedProduct extends OpMode {
    //Declare Inside Studio
    public CRServo intakeLeft;
    public CRServo intakeRight;
    public Servo topLeft;
    public Servo bottomLeft;
    public Servo topRight;
    public Servo bottomRight;
    public DcMotor lift;
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
    // Declare on the Phone
        intakeLeft = hardwareMap.crservo.get("intakeLeft");
        intakeRight = hardwareMap.crservo.get("intakeRight");
        topLeft = hardwareMap.servo.get("topLeft");
        bottomLeft = hardwareMap.servo.get("bottomRight");
        topRight = hardwareMap.servo.get("topRight");
        bottomRight = hardwareMap.servo.get("bottomRight");
        lift = hardwareMap.dcMotor.get("lift");
        motorLF = hardwareMap.dcMotor.get("motorLF");
        motorRB = hardwareMap.dcMotor.get("motorRB");
        motorLB = hardwareMap.dcMotor.get("motorLB");
        motorRF = hardwareMap.dcMotor.get("motorRF");
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
            intakeLeft.setPower(0);    //Tells Bot to Not Move
            intakeRight.setPower(0);
            lift.setPower(0);
        }
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
