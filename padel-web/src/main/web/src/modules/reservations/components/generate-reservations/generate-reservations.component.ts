import {
    AfterViewInit,
    ChangeDetectorRef,
    Component,
    EventEmitter,
    Inject,
    LOCALE_ID,
    OnChanges,
    OnInit,
    Output,
    SimpleChanges
} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourtTimeSlot, Group, Member, PlanningRequest, Week} from "@common/models";
import {ActivatedRoute, Router} from "@angular/router";
import {RouteData} from "@common/services/route-data.service";
import {ToastrService} from "ngx-toastr";
import moment from 'moment';
import {Moment} from "moment/moment";
import {combineLatest, Observable, of} from "rxjs";
import {map} from "rxjs/operators";
import {DateUtils} from "@common/utils/DateUtils";


@Component({
    selector: 'padel-generate-reservations',
    templateUrl: './generate-reservations.component.html',
    styleUrls: ['generate-reservations.component.scss'],
})
export class GenerateReservationsComponent implements OnInit, OnChanges, AfterViewInit {

    @Output() generatePlanning = new EventEmitter<PlanningRequest>();
    minPickerDate = "{year: " + new Date().getFullYear() + ", month: " + new Date().getMonth() + ", day: " + new Date().getDay() + "}";

    members$: Observable<Member[]>;
    group$: Observable<Group>;
    groups: Group[];
    groupMembers$: Observable<Member[]>;
    courtTimeSlots: CourtTimeSlot[] = [];
    groupMembers: Member[] = [];
    planningRequestForm: FormGroup;
    weeks: Week[] = [];


    //isFromDateDisabled = (date: NgbDate, current: {month: number}) => new Date(date.year,date.month-1,date.day).getDay() === 2 ||  new Date(date.year,date.month-1,date.day).getDay() === 3 || new Date(date.year,date.month-1,date.day).getDay() === 4 ||  new Date(date.year,date.month-1,date.day).getDay() === 4 ||  new Date(date.year,date.month-1,date.day).getDay() === 5 ||  new Date(date.year,date.month-1,date.day).getDay() === 6 ||  new Date(date.year,date.month-1,date.day).getDay() === 0;

    //isToDateDisabled = (date: NgbDate, current: {month: number}) => new Date(date.year,date.month-1,date.day).getDay() === 1 ||  new Date(date.year,date.month-1,date.day).getDay() === 2 || new Date(date.year,date.month-1,date.day).getDay() === 3 ||  new Date(date.year,date.month-1,date.day).getDay() === 4 ||  new Date(date.year,date.month-1,date.day).getDay() === 5 ||  new Date(date.year,date.month-1,date.day).getDay() === 6;

    constructor(
        @Inject(LOCALE_ID) public locale: string,private toastrService: ToastrService, private routeData: RouteData, private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder
    ) {
        this.planningRequestForm = this.fb.group({
            'fromDate': [""],
            'toDate': ["", Validators.required],
            'group': ["", Validators.required],
            'week': [""],
            'courtTimeSlot': [""],
            'members': [[]],
            'courtTimeSlotWeekList': this.fb.array([])

        });


        this.groups = this.route.snapshot.data['reservationResolverData']['groups'];
        this.courtTimeSlots = this.route.snapshot.data['reservationResolverData']['courtTimeSlots'];
        this.planningRequestForm.controls.group.setValue(this.groups[0]);


        this.members$ = of(this.route.snapshot.data['reservationResolverData']['members']);
        this.group$ = this.planningRequestForm.controls.group.valueChanges;
        this.groupMembers$ = combineLatest(this.members$, this.group$).pipe(
            map(([members, group]) =>
                members.filter(
                    member => member.groupAvailabilityList?.find((groupAvailability)=>groupAvailability?.group?.id==group.id)
                )
            )
        );

    }




    removeWeekCourtTimeSlot(index:number) {
        this.courtTimeSlotWeekList.removeAt(index);
    }


    filterMember(member: Member) {
        if (typeof this !== 'undefined'){

            let groupId :number = Math.floor(Math.random() * (6 - 1 + 1) + 1);;
            console.log("filterMember 1 " + groupId);
            if (member.groupAvailabilityList){

                if (member.groupAvailabilityList?.find((groupAvailability)=>groupAvailability?.group?.id==groupId)){
                    console.log("found")
                    return true;
                }
            }
        }


        return false;

    }

    get courtTimeSlotWeekList(): FormArray {
        return this.planningRequestForm.get('courtTimeSlotWeekList') as FormArray;
    }


    get weekCourtTimeSlot(): FormGroup {
        return this.fb.group({
            week: this.planningRequestForm.controls.week.value,
            courtTimeSlot: this.planningRequestForm.controls.courtTimeSlot.value,
        });
    }

    addWeekCourtTimeSlot(){
        console.log("week" + JSON.stringify(this.planningRequestForm.controls.week.value));
        console.log("courtTimeSlot" + JSON.stringify(this.planningRequestForm.controls.courtTimeSlot.value));
        this.courtTimeSlotWeekList.push(this.weekCourtTimeSlot);
        //let courtTimeSlot:CourtTimeSlotWeek = {};

        /*public class CourtTimeSlotWeek {
            private Week week;
            private List<CourtTimeSlot> courtTimeSlotList;

        courtTimeSlot:CourtTims
        this.courtTimeSlotWeekList.push({});*/
        //this.guidedSalesPassengersList.push(this.passengers);
        //this.planningRequestForm.controls.courtTimeSlotListByWeek.value = {};
    }


    /*get courtTimeSlotListByWeek(): Map<Week ,CourtTimeSlot[]> {
        return this.planningRequestForm.controls.courtTimeSlotListByWeek.value;
    }*/



    onSubmit() {
        const values = this.planningRequestForm.value;
        this.generatePlanning.emit(values);
        /*const values = this.planningRequestForm.value;

        const keys = Object.keys(values);

        if (this.planningRequestForm.valid) {
            this.update.emit(values);
        } else {
            keys.forEach(key => {
                console.log("key" + key);
                const ctrl = this.planningRequestForm.controls[key];
                if (key=="courtTimeSlotListByWeek"){
                    console.log("courtTimeSlotListByWeek" );
                    let courtTimeSlotListByWeek:Map<Week ,CourtTimeSlot[]>  = ctrl.value;

                    console.log("courtTimeSlotListByWeek" + courtTimeSlotListByWeek.size);

                }



                if (!ctrl.valid) {
                    ctrl.markAsTouched();
                    this.toastrService.warning("Niet alle gegevens zijn correct ingevuld", "Leden", {positionClass: 'toast-bottom-full-width'});
                }

            });
        }*/
    }



    compareFn(c1: any, c2: any): boolean {
        return c1 && c2 ? c1.id === c2.id : c1 === c2;
    }

    ngOnInit(): void {
        console.log("LOCALE_ID.toString()" + this.locale);


        this.planningRequestForm.controls.fromDate.setValue(new Date());
        this.planningRequestForm.controls.toDate.setValue("2021-06-30");



        this.weeks = [
            {weekOfYear:'13',weekOfMonth:'1',startWeekDay:'5/04/2021',endWeekDay:'11/04/2021',year:2021},
            {weekOfYear:'14',weekOfMonth:'2',startWeekDay:'12/04/2021',endWeekDay:'18/04/2021',year:2021},
            {weekOfYear:'15',weekOfMonth:'3',startWeekDay:'19/04/2021',endWeekDay:'25/04/2021',year:2021}
        ]

        //{id:1,{from:"",to:"",dayOfWeek:"MONDAY"},{id:1,name:"1"}},{id:1,{from:"",to:"",dayOfWeek:"MONDAY"},{id:1,name:"1"}}

        let map:Map<string, CourtTimeSlot[]> = new Map([["10", [{id:1,
            timeSlot : { from : "18:30", to : "20:00", dayOfWeek : "MONDAY"},
            court : { id : 1, name : "court1" }
        }]]]);
        /*let map:Map<string, string> = new Map([["10", "10"]]);*/

        let jsonObject:any = {};
        jsonObject["10"] =  [{id:1,
            timeSlot : { from : "18:30", to : "20:00", dayOfWeek : "MONDAY"},
            court : { id : 1, name : "court1" }
        },{id:1,
            timeSlot : { from : "18:30", to : "20:00", dayOfWeek : "MONDAY"},
            court : { id : 1, name : "court1" }
        }];
        /*map.forEach((value, key) => {
            // @ts-ignore
            jsonObject[key] = value
        });*/
        /*let map = new Map<string, string>()
        map.set('one', 'value1');
        map.set('two', 'value2');
        map.set('three', 'value3');
        let jsonObject = {};
        map.forEach((value, key) => {
            // @ts-ignore
            jsonObject[key] = value
        });*/
        //object: {[key: Week]: CourtTimeSlotList} = {{weekOfYear: 10,weekOfMonth: 1,startWeekDay: "monday",endWeekDay: "sunday",year: 2021}: []};
        //let courtTimeSlotListByWeek:Map<Week,CourtTimeSlot[]> = new Map([[ {weekOfYear: 10,weekOfMonth: 1,startWeekDay: "monday",endWeekDay: "sunday",year: 2021}, []]]);
        //object: {[key: number]: string} = {2: 'foo', 1: 'bar'};


        /*this.groupMembers$ = combineLatest(this.members$, this.group$).pipe(
            map( ([members, group]) => members.filter(member => member.id == 0))
        );*/

//            .pipe(map(([members,group]) => members.filter(member => member.))  )

        //.pipe(map(([districts,filterString]))) => districts.filter(district => district.name.lowerCase())}


        //this.planningRequestForm.controls.courtTimeSlotListByWeek.setValue(jsonObject);



    }



    onChangeGroup(event:any){

            //this.generateWeeks();
            //this.planningRequestForm.controls.members.setValue();

    }

    onChangeFromDate(event:any){

            this.generateWeeks();
            //this.planningRequestForm.controls.members.setValue();

    }






    generateWeeks(){
        console.log("generateWeeks 1");
        let control = <FormArray>this.planningRequestForm.controls.courtTimeSlotWeekList;
        control.clear();
        let weeks:Week[] = [];
        var startDate:Moment = moment(this.planningRequestForm.controls.fromDate.value);
        var toDate:Moment = moment(this.planningRequestForm.controls.toDate.value);
        var runningDate:Moment = startDate;
        console.log("generateWeeks 2");
        while (runningDate.isBefore(toDate) || runningDate.isSame(toDate)){
            let startWeekDay:string = runningDate.format("yyyy-MM-DD");
            console.log("startWeekDay" + startWeekDay);
            runningDate.add(6,"days");
            let year:number = runningDate.year();
            let weekOfYear:string = ''+DateUtils.getWeekOfYear(runningDate.toDate());
            console.log("weekOfYear" + weekOfYear);
            let weekOfMonth:string = ''+DateUtils.getWeekOfMonth(runningDate.toDate());
            console.log("weekOfMonth" + weekOfMonth);
            let endWeekDay:string = ''+runningDate.format("yyyy-MM-DD");
            console.log("endWeekDay" + endWeekDay);
            weeks.push({weekOfYear:weekOfYear,weekOfMonth:weekOfMonth,year:year,startWeekDay:startWeekDay,endWeekDay:endWeekDay})
        }

        weeks.forEach((week)=>control.push(this.fb.group({
                week: {weekOfMonth:week.weekOfMonth,weekOfYear:week.weekOfYear,startWeekDay:week.startWeekDay,endWeekDay:week.endWeekDay},
                courtTimeSlotList: []
            }),
        ));





    }

    onChangeToDate(event:any){
        this.generateWeeks();
    }






    ngAfterViewInit() {

    }

    ngOnChanges(changes: SimpleChanges): void {


    }


}




