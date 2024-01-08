package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Config Claw")
public class ClawConfig extends LinearOpMode {
    public Servo claw;
    public double factor = 0.1;

    public double target = factor;
    @Override
    public void runOpMode(){
        claw = hardwareMap.get(Servo.class, "CLAW");

        if(gamepad1.a){
            claw.setPosition(target);
            telemetry.addData("Current Position",target);
        }
        if(gamepad1.dpad_up){target+=factor;}
        if(gamepad1.dpad_down){target-=factor;}

        telemetry.update();

    }
}
