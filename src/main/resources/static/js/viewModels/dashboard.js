/**
 * @license
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your dashboard ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery','ojs/ojfilmstrip', 'ojs/ojpagingcontrol'],
 function(oj, ko, $) {
  
    function DashboardViewModel(){
      var self = this;
        // Please reference the oj-module jsDoc for additional information.
        self.pagingModel = ko.observable(null);
        self.chemicals = [
            { name: 'Hydrogen' },
            { name: 'Helium' },
            { name: 'Lithium' },
            { name: 'Beryllium' },
            { name: 'Boron' },
            { name: 'Carbon' }
        ];

        getItemInitialDisplay = function(index)
        {
            return index < 1 ? '' : 'none';
        };

        /*self.handleBindingsApplied = function()
        {
            console.log("=====--------");
            var filmStrip = document.getElementById('filmStrip');
            var busyContext = oj.Context.getContext(filmStrip).getBusyContext();
            busyContext.whenReady().then(function ()
            {
                // Set the Paging Control pagingModel
                console.log("=====");
                self.pagingModel(filmStrip.getPagingModel());
            });
        };*/

        // Below are a set of the ViewModel methods invoked by the oj-module component.
        self.handleBindingsApplied  = function(info) {
            // Implement if needed
            console.log("handleBindingsApplied ")
            var filmStrip = document.getElementById('filmStrip');
            var busyContext = oj.Context.getContext(filmStrip).getBusyContext();
            busyContext.whenReady().then(function ()
            {
                // Set the Paging Control pagingModel

                self.pagingModel(filmStrip.getPagingModel());
            });
        }

    }


    return new DashboardViewModel();
  }
);
