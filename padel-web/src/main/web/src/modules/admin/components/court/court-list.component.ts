import {
    ChangeDetectionStrategy,
    Component,
    HostListener,
    Input,
    OnChanges,
    OnDestroy,
    OnInit,
    SimpleChanges
} from '@angular/core';
import {GridOptions} from "ag-grid-community";
import {Court, Group, Member} from "@common/models";
import {ActivatedRoute, Router} from "@angular/router";
import {RouteData} from "@common/services/route-data.service";

@Component({
    selector: 'padel-court-list',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './court-list.component.html',
})
export class CourtListComponent implements OnInit,OnDestroy, OnChanges {
    @Input() courts: Array<Court> | undefined;


    public getRowNodeId: any;



    public gridOptions: GridOptions;
    public columnDefs: any[];

    public rowData: Array<Court> | undefined;
    public gridApi: any;

    constructor(private routeData:RouteData,private router: Router,private route: ActivatedRoute) {



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
                sortable: true,
                editable: false,
            },
            {
                headerName: "Naam",
                field: "name",
                filter: true,
                sortable: true,
                editable: false,
            },


        ];

    }


    onRowSelectionChanged(params: any) {

    }

    onCellEditingStarted(params: any) {

    }

    onRowDoubleClick(params: any) {
        this.routeData.storage = params.node.data;
        this.router.navigate(['./edit', params.node.data.id],{ relativeTo: this.route} );
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


    /*@HostListener('window:resize', ['$event'])
    onResize(event: any) {

        setTimeout(x => {
            this.gridApi.sizeColumnsToFit();
        }, 0);
    }*/

    onGridReady(params: any) {
        params.api.sizeColumnsToFit();
        this.gridApi = params.api;
        params.api.setFocusedCell(1, "name", null);
    }

    ngOnDestroy(): void {
    }

    ngOnChanges(changes: SimpleChanges): void {
        if (changes.courts && changes.courts.currentValue != null) {
            this.rowData = this.courts;

        }
    }

}


