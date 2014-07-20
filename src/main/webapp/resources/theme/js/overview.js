/**
 * Created by Rix on 7/12/14.
 */

$(document).ready(function()
    {
        $("#users").tablesorter({
            theme: 'blue',
            widgets        : ['zebra', 'columns'],
            usNumberFormat : false,
            sortReset      : true,
            sortRestart    : true
        });

        $("#protocols").tablesorter({
            theme: 'blue',
            widgets        : ['zebra', 'columns'],
            usNumberFormat : false,
            sortReset      : true,
            sortRestart    : true
        });

        $("#devices").tablesorter({
            theme: 'blue',
            widgets        : ['zebra', 'columns'],
            usNumberFormat : false,
            sortReset      : true,
            sortRestart    : true
        });
    }
);