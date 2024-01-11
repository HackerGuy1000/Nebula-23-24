package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class ArmConfig extends LinearOpMode {
    public DcMotor armMotor;
    @Override
    public void runOpMode(){
        armMotor = hardwareMap.get(DcMotor.class,"armMotor");

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while(opModeIsActive()){
            armMotor.setPower(gamepad1.right_stick_y);
            telemetry.addData("Current Position",armMotor.getCurrentPosition());
        }

    }

}
