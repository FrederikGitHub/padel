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
import {Member} from "@common/models";
import {ActivatedRoute, Router} from "@angular/router";
import {RouteData} from "@common/services/route-data.service";

@Component({
    selector: 'padel-member-list',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './member-list.component.html',
})
export class MemberListComponent implements OnInit,OnDestroy, OnChanges {
    @Input() members: Array<Member> | undefined;


    public getRowNodeId: any;



    public gridOptions: GridOptions;
    public columnDefs: any[];

    public rowData: Array<Member> | undefined;
    public gridApi: any;

    constructor(private routeData:RouteData, private router: Router,private route: ActivatedRoute) {



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
            {
                headerName: "Voornaam",
                field: "firstName",
                filter: true,
                sortable: true,
                editable: false,
            },
            {
                headerName: "Beschikbaar",
                valueGetter: function (params:any) {
                    let availability:string = "";
                    if (params.node.data.groupAvailabilityList){
                        for (let i=0;i < params.node.data.groupAvailabilityList.length;i++) {
                            availability = availability + "week " + params.node.data.groupAvailabilityList[i].availability.weekNumbers + " in " + params.node.data.groupAvailabilityList[i].group.name + ";";
                        }
                    }
                    return availability;
                },
                sortable: true,
                editable: false,
            },
            {
                headerName: "niveau",
                field: "vtvLevel.name",
                filter: true,
                sortable: true,
                editable: false,
            }

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
        if (changes.members && changes.members.currentValue != null) {
            this.rowData = this.members;

        }
    }

}


