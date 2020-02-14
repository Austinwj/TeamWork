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
            outline: 1px solid #363636;
        }

        .button1:hover {
            border: 1px solid cornflowerblue;
            color: white;
        }

        .button1:focus {
            position: relative;
            border: 2px solid cornflowerblue;
            top: 1px;
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


    <div class="Player1" style="float: left; margin-top: 20px; width: 15%;">

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

        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Status:
            </div>

            <div id="StatusP1"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">
                Died!
            </div>
        </div>

    </div>


    <div class="Player2" style="float: left; margin-left: 66px; margin-top: 20px; width: 15%; ">

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


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Status:
            </div>

            <div id="StatusP2"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">
                Died!
            </div>
        </div>

    </div>


    <div class="Player3" style="float: left; margin-left: 66px; margin-top: 20px; width: 15%; ">

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


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Status:
            </div>

            <div id="StatusP3"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">
                Died!
            </div>
        </div>

    </div>


    <div class="Player4" style="float: left; margin-left: 66px; margin-top: 20px; width: 15%; ">

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


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Status:
            </div>

            <div id="StatusP4"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">
                Died!
            </div>
        </div>

    </div>


    <div class="Player5" style="float: right; margin-left: 66px; margin-top: 20px; width: 15%; ">

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


        <div style="background-color: #363636; height: 20px; margin-top: 5px">
            <div style="float: left; color: white; font-weight: bold; font-size: 15px; margin-left: 10px; line-height: 20px;">
                Status:
            </div>

            <div id="StatusP5"
                 style="float: right; color: white; font-weight: bold; font-size: 15px; margin-right: 30px; line-height: 20px;">
                Died!
            </div>
        </div>

    </div>


    <div class="message" style="float: left; margin-top: 20px; width: 100%;">

        <div style="float: left; height: 20px; margin-top: 20px; width: 25%">
            <div style="float: left; margin-left: 10px; color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                Common Pile : &nbsp;
            </div>
            <div id="commonPile"
                 style="float: left; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 10%; text-align: center;">
                0
            </div>

        </div>

        <div style="float: left; height: 20px; margin-top: 20px; width: 50%">
            <div id="message"
                 style="background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 100%; text-align: center;">
                Hello!
            </div>

        </div>

        <div style="float: left; height: 20px; margin-top: 20px; width: 25%;">
            <div id="round"
                 style="float: right; margin-right: 50px; background-color:black; color: white; font-weight: bold; font-size: 15px;  line-height: 20px; width: 10%; text-align: center;">
                0
            </div>
            <div style="float: right; margin-right: 10px; color: black; font-weight: bold; font-size: 20px; line-height: 20px;">
                Round : &nbsp;
            </div>

        </div>


    </div>

</div>

<script type="text/javascript">


    // Method that is called on page load
    function initalize() {
        // --------------------------------------------------------------------------
        // You can call other methods you want to run when the page first loads here
        // --------------------------------------------------------------------------

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
    function newGame() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/newGame");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }


    function startGame() {
        var num = prompt("Enter the number of AI player:");
        if (num == null) {
            window.opener.location.reload();
        } else if (num >= "1" && num <= "4") {
            alert("Game Start!");
            reset();
            addPlayer(num);
            //drawCard();
            //sendCard();
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
    var list = undefined;

    function addPlayer(aiNum) {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/addPlayer?Number=" + aiNum); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            getCard();
            getPile();
            getRound();
            getMessage();
        }
        xhr.send();
    }

    function drawCard() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/drawCard"); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.send();
    }

    function choose(num) {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/choose?Number=" + num); // Request type and URL
        if (!xhr) {
            alert("CORS not supported");
        }
        //removeCard();
        getMessage();
        getCard();
        getPile();
        getRound();
        xhr.send();

    }

    function getCard() {
        var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getCard");
        if (!xhr) {
            alert("CORS not supported");
        }
        xhr.onload = function (e) {
            var responseText = xhr.response;
            list = jQuery.parseJSON(responseText);

            for (i = 0; i < 5; i++) {
                if (list[i] == null) {
                    continue;
                } else {
                    var j = i + 1;
                    document.getElementById("CardNameP" + j).innerHTML = list[i].name;
                    document.getElementById("SizeP" + j).innerHTML = list[i].size;
                    document.getElementById("SpeedP" + j).innerHTML = list[i].speed;
                    document.getElementById("RangeP" + j).innerHTML = list[i].range;
                    document.getElementById("FirepowerP" + j).innerHTML = list[i].firepower;
                    document.getElementById("CargoP" + j).innerHTML = list[i].cargo;
                    document.getElementById("StatusP" + j).innerHTML = "Alive";
                }

            }

        }
        xhr.send();
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


</script>

</body>
</html>