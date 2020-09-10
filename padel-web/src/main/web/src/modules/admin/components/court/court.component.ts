import {ChangeDetectionStrategy, Component, HostListener, OnInit} from '@angular/core';
import {GridOptions} from "ag-grid-community";

@Component({
    selector: 'padel-court',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court.component.html',
})
export class CourtComponent implements OnInit {

    public getRowNodeId: any;


    public gridOptions: GridOptions;
    public columnDefs: any[];

    public rowData: any[];
    public gridApi: any;

    constructor() {

        this.rowData = [{id: 1, name: 'Terrein1'}, {id: 2, name: 'Terrein2'}];

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


        /*setTimeout(x:any => {
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
