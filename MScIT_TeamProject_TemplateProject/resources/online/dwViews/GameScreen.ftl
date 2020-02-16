<html>

<head>
    <!-- Web page title -->
    <title>Top Trumps</title>

    <!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

    <!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
    <link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
    <script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    <script>vex.defaultOptions.className = 'vex-theme-os';</script>
    <link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    <link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .button {
            border: 1px;
            color: white;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            -webkit-transition-duration: 0.3s; /* Safari */
            transition-duration: 0.3s;
            cursor: pointer;
        }


        button[disabled] {
            border: 0px solid white;
            outline: 0px solid #363636;
            cursor: not-allowed
        }

        .button1 {
            background-color: #363636;
            color: white;
            border: 1px solid white;
            outline: 1px solid cornflowerblue;
        }

        .button1:hover {
            border: 1px solid cornflowerblue;
            color: white;
        }

        .button1:active {
            position: relative;
            border: 2px solid cornflowerblue;
            top: 2px;
            outline: 0
        }

        .button2 {
            background-color: #363636;
            color: white;
            border: 1px solid white;
            outline: 2px solid cornflowerblue;
        }

        .button2:hover {
            border: 2px solid cornflowerblue;
            color: white;
        }

        .button2:active {
            position: relative;
            border: 2px solid cornflowerblue;
            top: 3px;
            outline: 0
        }

        .button3 {
            background-color: #363636;
            color: white;
            border: 1px solid white;
            outline: 2px solid cornflowerblue;
        }

        .button3:hover {
            border: 2px solid cornflowerblue;
            color: white;
        }

        .button3:active {
            position: relative;
            border: 2px solid cornflowerblue;
            top: 3px;
            outline: 0
        }

        .button4 {
            background-color: #363636;
            color: white;
            border: 2px solid white;
            outline: 4px solid cornflowerblue;
        }

        .button4:hover {
            border: 2px solid cornflowerblue;
            color: white;
        }

        .button4:active {
            position: relative;
            border: 2px solid cornflowerblue;
            top: 3px;
            outline: 0
        }

    </style>

</head>

<body onload="initalize()">

<div class="container">

    <div class="header" style="background-color: #363636; height: 30px; width: 100%; text-align: center">
        <p style="color: white; font-weight: bold; font-size: 19px; line-height: 30px;">
            Top Trumps
        </p>
    </div>

    <div class="sub-header" style="margin-top: 20px">

        <a href="javascript:void(0);" onclick="startGame()">
            <div style="float: left; background-color: #363636; height: 20px; width: 30%; text-align: center">
                <div style="color: white; font-weight: bold; font-size: 15px; line-height: 20px;">
                    Start a New Game
                </div>

            </div>
        </a>

        <a href="http://localhost:7777/toptrumps/stats" onclick="window.close()">
            <div style="float: left; background-color: #363636; height: 20px; width: 30%; margin-left: 60px; text-align: center">
                <div style="color: white; font-weight: bold; font-size: 15px; line-height: 20px;">
                    Game Statistics
                </div>

            </div>
        </a>

        <a href="http://localhost:7777/toptrumps/" onclick="window.close()">
            <div style="float: right; background-color: #363636; height: 20px; width: 30%; margin-left: 50px; text-align: center">
                <div style="color: white; font-weight: bold; font-size: 15px; line-height: 20px;">
                    Exit Game
                </div>

            </div>
        </a>

    </div>


    <div id="Player1" style="float: left; margin-top: 20px; width: 15%;">

        <div style="height: 20px; margin-top: 20px ">
            <div id="playerName"
                 style="float: left; color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                You
            </div>
            <div id="leftCardsP1"
                 style="float: right; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 15%; text-align: center;">
                0
            </div>
            <div style="float: right; color: black; font-weight: bold; font-size: 10px;  line-height: 20px;">
                pile : &nbsp;
            </div>

        </div>

        <img id="PictureP1" class="card-img-top"
             src="https://i.imgur.com/hfR9Orq.png" style="margin-top: 5px; height: 8%">

        <div style="background-color: grey; height: 20px; margin-top: 5px; text-align: center">
            <div id="CardNameP1"
                 style="color: white; font-weight: bold; font-size: 20px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <button id="button1" type="button" class="button button1" onclick="choose(0)"
                    style="width: 100%; height: 20px;">
                <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 18px;">
                    Size:
                </div>

                <div id="SizeP1"
                     style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 18px;">

                </div>
            </button>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <button id="button2" type="button" class="button button1" onclick="choose(1)"
                    style="width: 100%; height: 20px;">
                <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                    Speed:
                </div>

                <div id="SpeedP1"
                     style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

                </div>
            </button>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <button id="button3" type="button" class="button button1" onclick="choose(2)"
                    style="width: 100%; height: 20px;">
                <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                    Range:
                </div>

                <div id="RangeP1"
                     style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

                </div>
            </button>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <button id="button4" type="button" class="button button1" onclick="choose(3)"
                    style="width: 100%; height: 20px;">
                <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                    Firepower:
                </div>

                <div id="FirepowerP1"
                     style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

                </div>
            </button>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <button id="button5" type="button" class="button button1" onclick="choose(4)"
                    style="width: 100%; height: 20px;">
                <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                    Cargo:
                </div>

                <div id="CargoP1"
                     style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

                </div>
            </button>
        </div>


    </div>


    <div id="Player2" style="float: left; margin-left: 66px; margin-top: 20px; width: 15%; ">

        <div style="height: 20px; margin-top: 20px ">
            <div style="float: left; color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                AI Player 1
            </div>
            <div id="leftCardsP2"
                 style="float: right; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 15%; text-align: center;">
                0
            </div>
            <div style="float: right; color: black; font-weight: bold; font-size: 10px;  line-height: 20px;">
                pile : &nbsp;
            </div>
        </div>

        <img id="PictureP2" class="card-img-top"
             src="https://i.imgur.com/hfR9Orq.png" style="margin-top: 5px; height: 8%">

        <div style="background-color: grey; height: 20px; margin-top: 5px; text-align: center">
            <div id="CardNameP2"
                 style="color: white; font-weight: bold; font-size: 20px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Size:
            </div>

            <div id="SizeP2"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Speed:
            </div>

            <div id="SpeedP2"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Range:
            </div>

            <div id="RangeP2"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Firepower:
            </div>

            <div id="FirepowerP2"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Cargo:
            </div>

            <div id="CargoP2"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


    </div>


    <div id="Player3" style="float: left; margin-left: 66px; margin-top: 20px; width: 15%; ">

        <div style="height: 20px; margin-top: 20px ">
            <div style="float: left; color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                AI Player 2
            </div>
            <div id="leftCardsP3"
                 style="float: right; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 15%; text-align: center;">
                0
            </div>
            <div style="float: right; color: black; font-weight: bold; font-size: 10px;  line-height: 20px;">
                pile : &nbsp;
            </div>
        </div>

        <img id="PictureP3" class="card-img-top"
             src="https://i.imgur.com/hfR9Orq.png" style="margin-top: 5px; height: 8%">

        <div style="background-color: grey; height: 20px; margin-top: 5px; text-align: center">
            <div id="CardNameP3"
                 style="color: white; font-weight: bold; font-size: 20px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Size:
            </div>

            <div id="SizeP3"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Speed:
            </div>

            <div id="SpeedP3"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Range:
            </div>

            <div id="RangeP3"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Firepower:
            </div>

            <div id="FirepowerP3"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Cargo:
            </div>

            <div id="CargoP3"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


    </div>


    <div id="Player4" style="float: left; margin-left: 66px; margin-top: 20px; width: 15%; ">

        <div style="height: 20px; margin-top: 20px ">
            <div style="float: left; color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                AI Player 3
            </div>
            <div id="leftCardsP4"
                 style="float: right; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 15%; text-align: center;">
                0
            </div>
            <div style="float: right; color: black; font-weight: bold; font-size: 10px;  line-height: 20px;">
                pile : &nbsp;
            </div>
        </div>

        <img id="PictureP4" class="card-img-top"
             src="https://i.imgur.com/hfR9Orq.png" style="margin-top: 5px; height: 8%">

        <div style="background-color: grey; height: 20px; margin-top: 5px; text-align: center">
            <div id="CardNameP4"
                 style="color: white; font-weight: bold; font-size: 20px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Size:
            </div>

            <div id="SizeP4"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Speed:
            </div>

            <div id="SpeedP4"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Range:
            </div>

            <div id="RangeP4"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Firepower:
            </div>

            <div id="FirepowerP4"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Cargo:
            </div>

            <div id="CargoP4"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


    </div>


    <div id="Player5" style="float: right; margin-left: 66px; margin-top: 20px; width: 15%; ">

        <div style="height: 20px; margin-top: 20px ">
            <div style="float: left; color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                AI Player 4
            </div>
            <div id="leftCardsP5"
                 style="float: right; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 15%; text-align: center;">
                0
            </div>
            <div style="float: right; color: black; font-weight: bold; font-size: 10px;  line-height: 20px;">
                pile : &nbsp;
            </div>
        </div>

        <img id="PictureP5" class="card-img-top"
             src="https://i.imgur.com/hfR9Orq.png" style="margin-top: 5px; height: 8%">

        <div style="background-color: grey; height: 20px; margin-top: 5px; text-align: center">
            <div id="CardNameP5"
                 style="color: white; font-weight: bold; font-size: 20px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Size:
            </div>

            <div id="SizeP5"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Speed:
            </div>

            <div id="SpeedP5"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Range:
            </div>

            <div id="RangeP5"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Firepower:
            </div>

            <div id="FirepowerP5"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Cargo:
            </div>

            <div id="CargoP5"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">

            </div>
        </div>



    </div>


    <div class="message" style="float: left; margin-top: 20px; width: 100%;">


        <div style="float: left; height: 20px; margin-top: 20px; width: 10%; margin-left: 10px">
            <button id="buttonSR" type="button" class="button button2" onclick="choose(5)"
                    style="width: 100%; height: 20px; line-height: 15px">
                Show Result
            </button>

        </div>

        <div style="float: left; height: 20px; margin-top: 20px; width: 10%; margin-left: 20px">
            <button id="buttonNR" type="button" class="button button3" onclick="nextRound()"
                    style="width: 100%; height: 20px; line-height: 15px">
                Next Round
            </button>

        </div>

        <div style="float: left; height: 20px; margin-top: 20px; width: 40%; margin-left: 50px">
            <div id="message"
                 style="float: left; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 100%; text-align: center;">
                Hello! If you want to play, please select Start a New Game!
            </div>

        </div>

        <div style="float: right; height: 20px; margin-top: 20px; width: 20%">
            <div id="commonPile"
                 style="float: right; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 10%; text-align: center;">
                0
            </div>

            <div style=" float: right;  color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                Common Pile : &nbsp;
            </div>

        </div>

        <div style="float: right; height: 20px; margin-top: 20px; width: 10%;">
            <div id="round"
                 style="float: right; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 25%; text-align: center;">
                0
            </div>
            <div style="float: right;  color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                Round : &nbsp;
            </div>

        </div>


    </div>

    <div class="showFinalWinner" style="float: left; margin-top: 20px; width: 100%;">

</div>

<script type="text/javascript">


    // Method that is called on page load
    function initalize() {
        // --------------------------------------------------------------------------
        // You can call other methods you want to run when the page first loads here
        // --------------------------------------------------------------------------
        button1Status(0);
        button2Status(0);
        button3Status(0);

    }

    // This is a reusable method for creating a CORS request. Do not edit this.
    function createCORSRequest(method, url) {
        var xhr = new XMLHttpRequest();
        if ("withCredentials" in xhr) {

            // Check if the XMLHttpRequest object has a "withCredentials" property.
            // "withCredentials" only exists on XMLHTTPRequest2 objects.
            xhr.open(method, url, true);

        } else if (typeof XDomainRequest != "undefined") {

            // Otherwise, check if XDomainRequest.
            // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
            xhr = new XDomainRequest();
            xhr.open(method, url);

        } else {

            // Otherwise, CORS is not supported by the browser.
            xhr = null;

        }
        return xhr;
    }

</script>

<script type="text/javascript">

    // -----------------------------------------
    // Add your other Javascript methods Here
    // -----------------------------------------

    function button1Status(x) {
        if (x == 0){
            for (var i = 1; i < 6 ; i ++){
                $('#button'+i).attr("disabled",true);
            }
        }
        else {
            for (var i = 1; i < 6 ; i ++){
                $('#button'+i).attr("disabled",false);
            }
        }
    }

    function button2Status(x) {
        if (x == 0){
            $('#buttonSR').attr("disabled",true);
        }
        else {
            $('#buttonSR').attr("disabled",false);
        }
    }

    function button3Status(x) {
        if (x == 0){
            $('#buttonNR').attr("disabled",true);
        }
        else {
            $('#buttonNR').attr("disabled",false);
        }
    }



    var list = undefined;
    var aiNum;
    var round;


    function startGame() {
        reset();
        var num = prompt("Enter the number of AI player:");
        if (num == null) {
            window.opener.location.reload();
        } else if (num >= "1" && num <= "4") {
            alert("Game Start!");
            addPlayer(num);
            aiNum = num;
            button1Status(0);
            button2Status(0);
            button3Status(1);
            $('#buttonNR').html("First Round");
            $('#buttonNR').removeClass("button button3");
            $('#buttonNR').addClass("button button4");
            $('#message').html("<---- Press to Enter First Round");
            $('.showFinalWinner').empty();


        } else if (num < "1") {
            alert("At least one AI player!")
            window.opener.location.reload();
        } else if (num > "4") {
            alert("Most 4 players!");
            window.opener.location.reload();
        }
    }

    // Add AI function
    // This calls the helloJSONList REST method from TopTrumpsRESTAPI

    function addPlayer(aiNum) {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/addPlayer?Number=" + aiNum); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            getCard();
        };
        xhr.send();
    }

    function nextRound() {
        button2Status(1);
        button3Status(0);
        $('#buttonNR').removeClass("button button4");
        $('#buttonNR').addClass("button button3");
        $('#buttonNR').html("Next Round");
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/nextRound"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            //var responseText = xhr.response;
            //document.getElementById("message").innerHTML = responseText;
            getRound();
            getPile();
            getPlayer();
            getCard();
            printP1Card();
            getMessage();
        }
        xhr.send();
    }


    function getPlayer() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getPlayer"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            if (responseText == "Human Player") {
                button1Status(1);
                button2Status(0);
                button3Status(0);
                //document.getElementById("message").innerHTML = "Now is your turn! Choose a Property!";
            } else {
                button1Status(0);
                button2Status(1);
                button3Status(0);
                //document.getElementById("message").innerHTML = "Now turn is " + responseText + ", Press Next Round to go on!";
            }

            setBorder(responseText);

        }
        xhr.send();

    }


    function choose(num) {
        button1Status(0);
        button2Status(0);
        button3Status(1);
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/choose?Number=" + num); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            getRoundWinner();
            getPile();
            getRound();
            getMessage();
            getCard();
            printAllCard();
            getGameWinner();
        };

        xhr.send();

    }

    function setBorder(x) {
        for (var i = 0; i < 5; i++) {
            var j = i + 1;
            if (x == "Human Player") {
                document.getElementById("Player1").style.border = "2px solid white";
                document.getElementById("Player1").style.outline = "2px solid goldenrod";
            } else if (x == "AI Player " + i) {
                document.getElementById("Player" + j).style.border = "2px solid white";
                document.getElementById("Player" + j).style.outline = "2px solid goldenrod";

            } else {
                document.getElementById("Player" + j).style.border = "2px solid white";
                document.getElementById("Player" + j).style.outline = "2px solid white";
            }
        }

    }


    function getCard() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getCard");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            list = jQuery.parseJSON(responseText);
        }


        xhr.send();
    }

    function printP1Card() {
        for (i = 0; i < 5; i++) {
            var j = i + 1;
            if (list[i] == null) {
                document.getElementById("PictureP" + j).src = "https://i.imgur.com/jzfwSpK.png";
                document.getElementById("CardNameP" + j).innerHTML = "";
                document.getElementById("SizeP" + j).innerHTML = "";
                document.getElementById("SpeedP" + j).innerHTML = "";
                document.getElementById("RangeP" + j).innerHTML = "";
                document.getElementById("FirepowerP" + j).innerHTML = "";
                document.getElementById("CargoP" + j).innerHTML = "";
            }
            else{
                document.getElementById("PictureP" + j).src = "http://dcs.gla.ac.uk/~richardm/TopTrumps/" + list[i].name + ".jpg";
                document.getElementById("CardNameP" + j).innerHTML = list[i].name;
                document.getElementById("SizeP" + j).innerHTML = list[i].size;
                document.getElementById("SpeedP" + j).innerHTML = list[i].speed;
                document.getElementById("RangeP" + j).innerHTML = list[i].range;
                document.getElementById("FirepowerP" + j).innerHTML = list[i].firepower;
                document.getElementById("CargoP" + j).innerHTML = list[i].cargo;
            }
        }

        for (i = 2; i < 6; i++) {
            var k = i - 1;
            if (list[k] == null) {
                $('#PictureP' + i).attr("src", "https://i.imgur.com/jzfwSpK.png");
            }
            else {
                $('#PictureP' + i).attr("src", "https://i.imgur.com/hfR9Orq.png");
            }
            $('#CardNameP'+i).empty();
            $('#SizeP'+i).empty();
            $('#SpeedP'+i).empty();
            $('#RangeP'+i).empty();
            $('#FirepowerP'+i).empty();
            $('#CargoP'+i).empty();
        }
    }

    function printAllCard() {
        for (i = 0; i < 5; i++) {
            var j = i + 1;
            if (list[i] == null) {
                document.getElementById("PictureP" + j).src = "https://i.imgur.com/jzfwSpK.png";
                document.getElementById("CardNameP" + j).innerHTML = "";
                document.getElementById("SizeP" + j).innerHTML = "";
                document.getElementById("SpeedP" + j).innerHTML = "";
                document.getElementById("RangeP" + j).innerHTML = "";
                document.getElementById("FirepowerP" + j).innerHTML = "";
                document.getElementById("CargoP" + j).innerHTML = "";

                if (i == 0) {
                    button1Status(0);
                    button2Status(0);
                    button3Status(0);
                    showFinalWinnerButton();
                    autoPlay();
                }

            }
            else{
                document.getElementById("PictureP" + j).src = "http://dcs.gla.ac.uk/~richardm/TopTrumps/" + list[i].name + ".jpg";
                document.getElementById("CardNameP" + j).innerHTML = list[i].name;
                document.getElementById("SizeP" + j).innerHTML = list[i].size;
                document.getElementById("SpeedP" + j).innerHTML = list[i].speed;
                document.getElementById("RangeP" + j).innerHTML = list[i].range;
                document.getElementById("FirepowerP" + j).innerHTML = list[i].firepower;
                document.getElementById("CargoP" + j).innerHTML = list[i].cargo;
            }
        }
    }



    function getPile() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getPile");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            var pilelist = jQuery.parseJSON(responseText);

            for (i = 0; i < 5; i++) {
                var k = i + 1;
                if (pilelist[i] == 0) {
                    continue;
                } else {
                    var j = i + 1;
                    document.getElementById("leftCardsP" + j).innerHTML = pilelist[i];
                }
            }

            document.getElementById("commonPile").innerHTML = pilelist[5];

        }
        xhr.send();
    }


    function getRound() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getRound");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            document.getElementById("round").innerHTML = responseText;
            round = responseText;
        }
        xhr.send();
    }


    function getMessage() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getMessage");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            document.getElementById("message").innerHTML = responseText;
        }
        xhr.send();
    }

    function getRoundWinner() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getRoundWinner");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            for (var i = 0; i < 4; i++) {
                var j = i + 1;
                if (responseText == i) {
                    document.getElementById("Player" + j).style.border = "2px solid white";
                    document.getElementById("Player" + j).style.outline = "2px solid goldenrod";
                } else {
                    document.getElementById("Player" + j).style.border = "2px solid white";
                    document.getElementById("Player" + j).style.outline = "2px solid white";
                }
            }
        }
        xhr.send();
    }


    function getGameWinner() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getGameWinner");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            if (responseText == 1){
                button1Status(0);
                button2Status(0);
                button3Status(0);
                saveGameStatistics();
            }
        }
        xhr.send();
    }


    function removeCard() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/removeCard"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }

    function reset() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/reset"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }

    function saveGameStatistics() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/saveGameStatistics"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }

    function showFinalWinnerButton() {
        button1Status(0);
        button2Status(0);
        button3Status(0);
        $('.showFinalWinner').html("<div style=\"height: 20px; margin-top: 20px; width: 30%; margin-left: 35%\">\n" +
            "            <button id=\"buttonSFW\" type=\"button\" class=\"button button2\" onclick=\"showFinalWinner()\"\n" +
            "                    style=\"width: 100%; height: 20px; line-height: 15px;\">\n" +
            "                Directly Show Final Winner\n" +
            "            </button>\n" +
            "\n" +
            "        </div>");
    }

    function showFinalWinner() {
        button1Status(0);
        button2Status(0);
        button3Status(0);

        getPlayer();
        getPile();
        getRound();
        getMessage();
        getCard();
        printAllCard();
        $('#buttonSFW').attr("disabled",true);
        getGameWinner();
    }

    function autoPlay() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/autoPlay"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }



</script>

</body>
</html>