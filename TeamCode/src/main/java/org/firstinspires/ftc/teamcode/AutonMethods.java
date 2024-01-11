package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class AutonMethods {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    public void hardwareMap(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotor.class, "FL");
        frontRight = hardwareMap.get(DcMotor.class, "FR");
        backLeft = hardwareMap.get(DcMotor.class, "BL");
        backRight = hardwareMap.get(DcMotor.class, "BR");

    }
    public void Drive(double theta, double power, double turn){
        double sin = Math.sin(theta-Math.PI/4);
        double cos = Math.cos(theta - Math.PI/4);
        double max = Math.max(Math.abs(sin),Math.abs(cos));

        double fl_power = power * cos/max + turn;
        double fr_power = power * sin/max - turn;
        double bl_power = power * sin/max + turn;
        double br_power = power * cos/max - turn;
        if((power + Math.abs(turn))> 1){
            fl_power /= power + turn;
            fr_power /= power + turn;
            bl_power /= power + turn;
            br_power /= power + turn;
        }


    }
}
