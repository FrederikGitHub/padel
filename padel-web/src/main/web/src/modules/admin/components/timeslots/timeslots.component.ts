import {ChangeDetectionStrategy, Component, HostListener, OnInit} from '@angular/core';
import {GridOptions} from "ag-grid-community";

@Component({
    selector: 'padel-timeslots',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './timeslots.component.html',
})
export class TimeslotsComponent implements OnInit {

    public getRowNodeId: any;


    public gridOptions: GridOptions;
    public columnDefs: any[];

    public rowData: any[];
    public gridApi: any;

    constructor() {

        this.rowData = [
            {id: 1, day: 'Maandag',from:"08:00",to:"09:30",court:"Padel 1"},
            {id: 2, day: 'Maandag',from:"09:30",to:"11:00",court:"Padel 1"},
            {id: 3, day: 'Maandag',from:"11:00",to:"12:30",court:"Padel 1"},
            {id: 4, day: 'Maandag',from:"12:30",to:"14:00",court:"Padel 1"},
            {id: 5, day: 'Maandag',from:"14:00",to:"15:30",court:"Padel 1"},
            {id: 6, day: 'Maandag',from:"15:30",to:"17:00",court:"Padel 1"},
            {id: 7, day: 'Maandag',from:"17:00",to:"18:30",court:"Padel 1"},
            {id: 8, day: 'Maandag',from:"18:30",to:"20:00",court:"Padel 1"},
            {id: 9, day: 'Maandag',from:"20:00",to:"21:30",court:"Padel 1"},
            {id: 10, day: 'Maandag',from:"21:30",to:"23:00",court:"Padel 1"},
        ];

        this.gridOptions = <GridOptions>{
            rowSelection: 'single'
        };

        this.getRowNodeId = function (data: any) {
            return data.id;
        };

        this.columnDefs = [
            {
                headerName: "id",
                field: "id",
                editable: false,
            },
            {
                headerName: "Dag",
                field: "day",
                editable: true,
            },
            {
                headerName: "Van",
                field: "from",
                editable: true,
            },
            {
                headerName: "Tot",
                field: "to",
                editable: true,
            },
            {
                headerName: "Terrein",
                field: "court",
                editable: true,
            },
        ];

    }


    onRowSelectionChanged(params: any) {

    }

    onCellEditingStarted(params: any) {

    }


    onSelectionChanged(params: any) {


    }


    ngOnInit() {


        /*setTimeout(x => {
            this.gridApi.sizeColumnsToFit();
        }, 0);*/

    }


    onRowEditingStarted(params: any) {

    }


    onRowValueChanged(params: any) {


    }

    onRowEditingStopped(params: any) {

    }

    onCellValueChanged(params: any) {
        //this.store.dispatch(new DossierActions.UpdateOrderItemAction(params.node.data));
    }

    onCellEditingStopped(params: any) {

    }


    @HostListener('window:resize', ['$event'])
    onResize(event: any) {

        /*setTimeout(x => {
            this.gridApi.sizeColumnsToFit();
        }, 0);*/
    }

    onGridReady(params: any) {
        params.api.sizeColumnsToFit();
        this.gridApi = params.api;
        params.api.setFocusedCell(1, "name", null);
    }
}



