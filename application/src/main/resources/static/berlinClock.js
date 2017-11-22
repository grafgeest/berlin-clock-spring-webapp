$(document).ready(function(){
    var BerlinClock = function(){
        var msg = $.ajax({type: "GET", url: "/get-berlin-clock-time", async: false}).responseText;
        var time = new Date();
        var array = msg.split("\n");
        var secLamp = array[0];
        var redRow1 = array[1].split("");
        redRow1.splice(-1,1);
        var redRow2 = array[2].split("");
        redRow2.splice(-1,1);
        var yellowRow1 = array[3].split("");
        yellowRow1.splice(-1,1);
        var yellowRow2 = array[4].split("");
        yellowRow2.splice(-1,1);

        var berlinClock = [secLamp, redRow1, redRow2, yellowRow1, yellowRow2];

        for(var i = 0; i < berlinClock.length; i++){
            for(var j = 0; j < berlinClock[i].length; j++){
                if(berlinClock[i][j] === "R"){$("#" + i + "_" + j).addClass("red");}
                else if(berlinClock[i][j] === "Y"){$("#" + i + "_" + j).addClass("yellow");}
                else {$("#" + i + "_" + j).removeClass("red").removeClass("yellow")};
            }
        }
        
        var hours = time.getHours();
        var minutes = time.getMinutes();
        var seconds = time.getSeconds();
        $('.time').text(hours + ":" + minutes + ":" + seconds);
    };

    setInterval(function(){
        BerlinClock();
    }, 1000);
});