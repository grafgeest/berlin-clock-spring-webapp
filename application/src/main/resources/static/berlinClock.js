$(document).ready(function(){
    var BerlinClock = function(){
        var now = getTime();

        var msg = $.ajax({type: "GET", url: "/get-berlin-clock-time?time=" + now, async: false}).responseText;

        var array = msg.split("\n");
        var secLamp = array[0];
        var redRow1 = array[1].split("");
        var redRow2 = array[2].split("");
        var yellowRow1 = array[3].split("");
        var yellowRow2 = array[4].split("");
        redRow1.splice(-1,1);
        redRow2.splice(-1,1);
        yellowRow1.splice(-1,1);
        yellowRow2.splice(-1,1);

        var berlinClock = [secLamp, redRow1, redRow2, yellowRow1, yellowRow2];

        for(var i = 0; i < berlinClock.length; i++){
            for(var j = 0; j < berlinClock[i].length; j++){
                if(berlinClock[i][j] === "R"){$("#" + i + "_" + j).addClass("red");}
                else if(berlinClock[i][j] === "Y"){$("#" + i + "_" + j).addClass("yellow");}
                else {$("#" + i + "_" + j).removeClass("red").removeClass("yellow")};
            }
        }

        $('.time').text(now);
    };

    var getTime = function() {
        var now = new Date();
        dateText = now.toTimeString();
        dateText = dateText.split(' ')[0];

        return dateText;
    };

    setInterval(function(){
        BerlinClock();
    }, 1000);
});