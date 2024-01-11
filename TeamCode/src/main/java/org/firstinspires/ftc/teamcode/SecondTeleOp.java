package org.firstinspires.ftc.teamcode;
//Nebuala 12382
//Simply two wheel tak drive




import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


//1. Annotate teleop
//2. Extend the OpMode class and implement required methods
@TeleOp(name="Tank Drive T Philip")
public class SecondTeleOp extends OpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;

    DcMotor armMotor;

    public final int UP_POSITION = 0;
    public final int DOWN_POSITION = 0;

    @Override
    public void init() {
        //4. Hardware map the motors
        leftMotor = hardwareMap.get(DcMotor.class,"leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class,"rightMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");


        //5. Set the motors to the proper direction
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }


    @Override
    public void loop() {
        //6. Set power based on gamestick y values
        leftMotor.setPower(-gamepad1.left_stick_y);
        rightMotor.setPower(-gamepad1.right_stick_y);

        if(gamepad1.dpad_up){
            armMotor.setTargetPosition(UP_POSITION);
        }
        if(gamepad1.dpad_down){
            armMotor.setTargetPosition(DOWN_POSITION);
        }
    }
}

