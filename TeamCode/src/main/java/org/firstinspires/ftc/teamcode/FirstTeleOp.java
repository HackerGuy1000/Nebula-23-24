package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="First TeleOp")
public class FirstTeleOp extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public Servo claw;

    public final double CLAW_UP = 0.0;

    public final double CLAW_DOWN = 0.0;

    @Override
    public void runOpMode() {
        //Maps the motors to different variables
        frontLeft = hardwareMap.get(DcMotor.class, "FL");
        frontRight = hardwareMap.get(DcMotor.class, "FR");
        backLeft = hardwareMap.get(DcMotor.class, "BL");
        backRight = hardwareMap.get(DcMotor.class, "BR");
        claw = hardwareMap.get(Servo.class, "CLAW");

        //Sets motors to not use encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Reverses right side motors
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        boolean clawUp = false;

        waitForStart();

        while(opModeIsActive()){
            //calculates the values for drive, strafe and spin movement
            double drive = gamepad1.left_stick_y * 0.5;
            double strafe = -gamepad1.left_stick_x * 0.7;
            double spin = gamepad1.right_stick_x * 0.4;

            frontLeft.setPower(drive + strafe + spin);
            frontRight.setPower(drive - strafe - spin);
            backLeft.setPower(drive - strafe + spin);
            backRight.setPower(drive + strafe -spin);

            if(gamepad1.a){
                if(clawUp){
                    claw.setPosition(CLAW_UP);
                }
                else{
                    claw.setPosition(CLAW_DOWN);
                }
            }


        }
    }
}
