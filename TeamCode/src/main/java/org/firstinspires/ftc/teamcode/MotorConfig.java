package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "mtrcfig")
public class MotorConfig extends LinearOpMode {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    @Override
    public void runOpMode() {
        //Maps the motors to different variables
        frontLeft = hardwareMap.get(DcMotor.class, "FL");
        frontRight = hardwareMap.get(DcMotor.class, "FR");
        backLeft = hardwareMap.get(DcMotor.class, "BL");
        backRight = hardwareMap.get(DcMotor.class, "BR");

        //Sets motors to not use encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Reverses right side motors
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {


            if (gamepad1.dpad_up) {
                frontLeft.setPower(1);
            }
            else{frontLeft.setPower(0);}
            if (gamepad1.dpad_right) {
                frontRight.setPower(1);
            }
            else{frontRight.setPower(0);}
            if (gamepad1.dpad_left) {
                backLeft.setPower(1);
            }
            else{backLeft.setPower(0);}
            if (gamepad1.dpad_down) {
                backRight.setPower(1);
            }
            else{backRight.setPower(0);}
        }
    }
}
