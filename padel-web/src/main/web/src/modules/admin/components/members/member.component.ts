import {
    AfterViewInit,
    ChangeDetectionStrategy,
    ChangeDetectorRef,
    Component,
    EventEmitter,
    OnChanges,
    OnInit,
    Output,
    SimpleChanges
} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Availability, Group, Member} from "@common/models";
import {ActivatedRoute, Router} from "@angular/router";
import {RouteData} from "@common/services/route-data.service";
import {ToastrService} from "ngx-toastr";


@Component({
    selector: 'padel-member',
    changeDetection: ChangeDetectionStrategy.OnPush,
    templateUrl: './member.component.html',
})
export class MemberComponent implements OnInit, OnChanges, AfterViewInit {

    @Output() update = new EventEmitter<Member>();

    groups: Group[] = [];
    availabilities: Availability[] = [];
    levels: string[] = [];
    genders: string[] = [];


    memberForm: FormGroup;


    constructor(private toastrService: ToastrService, private routeData: RouteData, private cd: ChangeDetectorRef, private route: ActivatedRoute, private router: Router, private fb: FormBuilder) {
        this.memberForm = this.fb.group({
            'id': [""],
            'name': ["", Validators.required],
            'firstName': ["", Validators.required],
            'email': ["", Validators.email],
            'gsm': [""],
            'level': ["", Validators.required],
            'gender': ["", Validators.required],
            'groupAvailabilityList': this.fb.array([]),
            'active': [""],
        });
    }

    get groupAvailabilityList(): FormArray {
        return this.memberForm.get('groupAvailabilityList') as FormArray;
    }

    public closePopup() {
        /* If we do not write this line then auxiliary route url will persist
        even if we close the pop-up. So we set the modal outlet to null */
        this.router.navigate(['expert']);
        // To close the pop up

    }

    duplicateGroupAvailability() {

        this.groupAvailabilityList.push(this.fb.group({
            availability: this.availabilities[0],
            group: this.groups[0],
        }));
    }

    removeGroupAvailability(index:number) {
        this.groupAvailabilityList.removeAt(index);
    }

    addMember() {
        this.memberForm.reset({id:-1});
        this.groupAvailabilityList.clear();
        this.groupAvailabilityList.push(this.fb.group({
            availability: this.availabilities[0],
            group: this.groups[0],
        }));

    }

    removeMember() {
        this.memberForm.get('active')?.setValue('N');
        this.router.navigate(['admin/members']);
    }

    test(){
        this.toastrService.warning("Niet alle gegevens zijn correct ingevuld", "Leden", {positionClass: 'toast-bottom-full-width'});
    }

    onSubmit() {
        const values = this.memberForm.value;

        const keys = Object.keys(values);

        if (this.memberForm.valid) {
            this.update.emit(values);
        } else {
            keys.forEach(key => {
                const ctrl = this.memberForm.controls[key];
                if (!ctrl.valid) {
                    ctrl.markAsTouched();
                    this.toastrService.warning("Niet alle gegevens zijn correct ingevuld", "Leden", {positionClass: 'toast-bottom-full-width'});
                }

            });
        }
    }

    fillFormData(member: Member) {
        this.memberForm.controls.name.setValue(member.name);
        this.memberForm.controls.firstName.setValue(member.firstName);
        this.memberForm.controls.email.setValue(member.email);
        this.memberForm.controls.gsm.setValue(member.gsm);
        this.memberForm.controls.level.setValue(member.level);
        this.memberForm.controls.gender.setValue(member.gender);


        if (member && member.groupAvailabilityList) {
            //this.deliveryForm.controls.dossierDeliveryMode.setValue(deliveryDialogForm.dossierDeliveryMode);


            let control = <FormArray>this.memberForm.controls.groupAvailabilityList;

            member.groupAvailabilityList.forEach(groupAvailability => {

                control.push(this.fb.group({
                        availability: groupAvailability.availability,
                        group: groupAvailability.group
                    }),
                );
            });
        }


    }

    compareFn(c1: any, c2: any): boolean {
        return c1 && c2 ? c1.id === c2.id : c1 === c2;
    }

    ngOnInit(): void {
        this.fillFormData(this.routeData.storage);
        this.availabilities = this.route.snapshot.data['memberResolverData']['availabilities'];
        this.groups = this.route.snapshot.data['memberResolverData']['groups'];
        this.levels = this.route.snapshot.data['memberResolverData']['levels'];
        this.genders = this.route.snapshot.data['memberResolverData']['genders'];
    }


    ngAfterViewInit() {
        this.cd.detectChanges();
    }

    ngOnChanges(changes: SimpleChanges): void {


    }


}



