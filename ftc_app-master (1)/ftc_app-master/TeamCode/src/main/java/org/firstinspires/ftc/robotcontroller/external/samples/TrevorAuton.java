package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name="TrevorAuton")
public class TrevorAuton extends LinearOpMode {
    public DcMotor motorLF;
    public DcMotor motorLB;
    public DcMotor motorRF;
    public DcMotor motorRB;
    public CRServo intakeLeft;
    public CRServo intakeRight;

// tell A.S what to use
    @Override
    public void runOpMode() throws InterruptedException {
        motorLF = hardwareMap.dcMotor.get("motorLF");
        motorLB = hardwareMap.dcMotor.get("motorLB");
        motorRF = hardwareMap.dcMotor.get("motorRF");
        motorRB = hardwareMap.dcMotor.get("motorRB");
        intakeLeft = hardwareMap.crservo.get("intakeLeft");
        intakeRight = hardwareMap.crservo.get("intakeRight");
        //tell Phone what to use

        waitForStart();
        //actual movement starts here
        //sleep(milliseconds) tells the robot to stop moving for "x" ms
        //motor full power
        //sleep(5000)
        motorRF.setPower(.5);
        motorRB.setPower(.5);
        motorLB.setPower(.5); //
        motorLF.setPower(.5);
        sleep(5000);
    }
}
