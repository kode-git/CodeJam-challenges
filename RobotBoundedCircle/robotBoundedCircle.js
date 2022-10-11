/*
On an infinite place, a robot initialy stands at (0,0) and faces north. The robot can reeive one of three instructions:
- "G": go straight 1 unit
- "L": turn 90 degrees to the left
- "R": turn 90 degrees to the right

The robot performs the instructions given in order, and repeats them forever

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Example 1:
Input: "GGLLGG"
Output: True

Example 2:
Input: "GG"
Output: False

Example 3:
Input: "GL"
Output: True

Constraints:
instructions[i] == G | L | R
instructions.length <= 100
*/

class Solution {
    
    updateOrientation(rotation, orientation){
        switch(rotation){
            case "L": orientation = (orientation + 90) % 360; break;
            case "R": orientation = (orientation - 90) % 360; break;
            case "G": return orientation;
            default: return -1;
        }
        return orientation
    }


    isRobotBounded(instructions) {
        if(instructions.length == 0 || instructions == null) return false;
        let currentOrientation = 90; // 0, 90, 180, 270 

        // (x,y) is the intiial location
        let x = 0
        let y = 0

        for(let i = 0; i < instructions.length; i++){
            let inst = instructions[i]
            currentOrientation = this.updateOrientation(inst, currentOrientation);
            if(currentOrientation == -1 ) return false; // invalid input
            if(inst == "G"){
                switch(currentOrientation){
                    case 0: x += 1; break;
                    case 90: y += 1; break;
                    case 180: x-= 1; break;
                    case 270: y-= 1; break;
                    default: break;
                }
            }
        }

        return x == 0 && y == 0 || currentOrientation != 90;
    }
}


function main(){
    let solution = new Solution();
    console.log(solution.isRobotBounded("GGLLGG"))
}

main();