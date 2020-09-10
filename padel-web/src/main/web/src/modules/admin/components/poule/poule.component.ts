import {ChangeDetectionStrategy, Component, HostListener, OnInit} from '@angular/core';
import {GridOptions} from "ag-grid-community";

@Component({
    selector: 'padel-poule',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './poule.component.html',
})
export class PouleComponent implements OnInit {

    public getRowNodeId: any;


    public gridOptions: GridOptions;
    public columnDefs: any[];

    public rowData: any[];
    public gridApi: any;

    constructor() {

        this.rowData = [{id: 1, name: 'Poule 1'}, {id: 2, name: 'Poule 2'},{id: 3, name: 'Poule 3'}, {id: 4, name: 'Poule 4'},{id: 5, name: 'Poule 5'}, {id: 6, name: 'Poule 6'},{id: 7, name: 'Poule 7'}, {id: 8, name: 'Poule 8'},{id: 9, name: 'Poule 9'}, {id: 10, name: 'Poule 10'}];

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
                headerName: "Naam",
                field: "name",
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


