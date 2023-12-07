package autofox.objects.objectSystem.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Bool;
import org.apache.maven.settings.Settings;

import java.security.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUsersPojo {

    @JsonProperty("status")
    public int status;

    @JsonProperty("data")
    public UserData data;

    // getters and setters


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserData {
        //Constructor {Master and Super}
        public UserData(String Email ,String UserName  ,String FirstName ,String LastName ,String CompanyName ,String CompanyAddress ,String Language , String Country ){
            this.email = Email;
            this.username = UserName ;
            this.firstName = FirstName;
            this.lastName = LastName;
            this.companyName = CompanyName ;
            this.companyAddress = CompanyAddress ;
            this.language = Language ;
            this.countryId = Country;

        }

            //Constructor {Designers}
            public UserData(String Email ,String UserName  ,String FirstName ,String LastName ,String CompanyName ,String CompanyAddress ,String Language , String Country , Boolean Training ,  int Target , String WorkingDays ){
                this.email = Email;
                this.username = UserName ;
                this.firstName = FirstName;
                this.lastName = LastName;
                this.companyName = CompanyName ;
                this.companyAddress = CompanyAddress ;
                this.language = Language ;
                this.countryId = Country;
                AdminSettings adminSettings = new AdminSettings(Training , Target , WorkingDays);
               setAdminSettings(adminSettings);
            }


        @JsonProperty("id")
        public int id;

        @JsonProperty("email")
        public String email;

        @JsonProperty("username")
        public String username;

        @JsonProperty("first_name")
        public String firstName;

        @JsonProperty("last_name")
        public String lastName;

        @JsonProperty("company_name")
        public String companyName;

        @JsonProperty("company_address")
        public String companyAddress;

        @JsonProperty("phone")
        public String phone;

        @JsonProperty("postal_code")
        public String postalCode;

        @JsonProperty("region")
        public String region;

        @JsonProperty("language")
        public String language;

        @JsonProperty("date_joined")
        public String dateJoined;

        @JsonProperty("date_deleted")
        public String dateDeleted;

        @JsonProperty("last_login")
        public String lastLogin;


        @JsonProperty("is_master_user")
        public boolean isMasterUser;

        @JsonProperty("is_superuser")
        public boolean isSuperuser;

        @JsonProperty("is_staff")
        public boolean isStaff;

        @JsonProperty("is_active")
        public boolean isActive;

        @JsonProperty("login_token")
        public String loginToken;

        @JsonProperty("balance")
        public String balance;

        @JsonProperty("vin_query_balance")
        public String vinQueryBalance;

        @JsonProperty("registration_document_balance")
        public String registrationDocumentBalance;

        @JsonProperty("retouch_balance")
        public String retouchBalance;

        @JsonProperty("subscription_start_date")
        public String subscriptionStartDate;

        @JsonProperty("subscription_end_date")
        public String subscriptionEndDate;

        @JsonProperty("is_subscription_active")
        public boolean isSubscriptionActive;

        @JsonProperty("subscription_type")
        public String subscriptionType;

        @JsonProperty("position_template_ids")
        public String[] positionTemplateIds;

        @JsonProperty("no_ai_position_template_ids")
        public String[] noAiPositionTemplateIds;

        @JsonProperty("retouch_position_template_ids")
        public String[] retouchPositionTemplateIds;

        @JsonProperty("sorted_position_template_ids")
        public String[] sortedPositionTemplateIds;

        @JsonProperty("user_export_sort_ids")
        public String[] userExportSortIds;

        @JsonProperty("export_sort_last_update")
        public String exportSortLastUpdate;

        @JsonProperty("settings")
        public UserSettings settings;

        @JsonProperty("user_position_templates")
        public String[] userPositionTemplates;

        @JsonProperty("country_id")
        public String countryId;

        @JsonProperty("working_status")
        public String workingStatus;

        @JsonProperty("is_training_retoucher")
        public boolean isTrainingRetoucher;

        @JsonProperty("last_active")
        public String lastActive;

        @JsonProperty("last_subscription_start_date")
        public String lastSubscriptionStartDate;

        @JsonProperty("last_subscription_end_date")
        public String lastSubscriptionEndDate;

        @JsonProperty("sub_users_ids")
        public String[] subUsersIds;

        @JsonProperty("user_vehicle_package")
        public UserVehiclePackage userVehiclePackage;

        @JsonProperty("img_width")
        public int imgWidth;

        @JsonProperty("admin_settings")
        public AdminSettings adminSettings;

        @JsonProperty("is_organization")
        public boolean isOrganization;

        @JsonProperty("login_qr_file")
        public String loginQrFile;

        @JsonProperty("branch_id")
        public String branchId;

        @JsonProperty("organization_id")
        public String organizationId;

        @JsonProperty("user_permissions")
        public String[] userPermissions;

        @JsonProperty("is_organization_mail_enabled")
        public boolean isOrganizationMailEnabled;

        @JsonProperty("is_organization_mail_copied_to_dealer")
        public boolean isOrganizationMailCopiedToDealer;

        @JsonProperty("template_images_ids")
        public String[] templateImagesIds;

        @JsonProperty("is_working")
        public boolean isWorking;

        // getters and setters


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getDateJoined() {
            return dateJoined;
        }

        public void setDateJoined(String dateJoined) {
            this.dateJoined = dateJoined;
        }

        public String getDateDeleted() {
            return dateDeleted;
        }

        public void setDateDeleted(String dateDeleted) {
            this.dateDeleted = dateDeleted;
        }

        public String getLastLogin() {
            return lastLogin;
        }

        public void setLastLogin(String lastLogin) {
            this.lastLogin = lastLogin;
        }

        public boolean isSuperuser() {
            return isSuperuser;
        }

        public void setSuperuser(boolean superuser) {
            isSuperuser = superuser;
        }

        public boolean isStaff() {
            return isStaff;
        }

        public void setStaff(boolean staff) {
            isStaff = staff;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public String getLoginToken() {
            return loginToken;
        }

        public void setLoginToken(String loginToken) {
            this.loginToken = loginToken;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getVinQueryBalance() {
            return vinQueryBalance;
        }

        public void setVinQueryBalance(String vinQueryBalance) {
            this.vinQueryBalance = vinQueryBalance;
        }

        public String getRegistrationDocumentBalance() {
            return registrationDocumentBalance;
        }

        public void setRegistrationDocumentBalance(String registrationDocumentBalance) {
            this.registrationDocumentBalance = registrationDocumentBalance;
        }

        public String getRetouchBalance() {
            return retouchBalance;
        }

        public void setRetouchBalance(String retouchBalance) {
            this.retouchBalance = retouchBalance;
        }

        public String getSubscriptionStartDate() {
            return subscriptionStartDate;
        }

        public void setSubscriptionStartDate(String subscriptionStartDate) {
            this.subscriptionStartDate = subscriptionStartDate;
        }

        public String getSubscriptionEndDate() {
            return subscriptionEndDate;
        }

        public void setSubscriptionEndDate(String subscriptionEndDate) {
            this.subscriptionEndDate = subscriptionEndDate;
        }

        public boolean isSubscriptionActive() {
            return isSubscriptionActive;
        }

        public void setSubscriptionActive(boolean subscriptionActive) {
            isSubscriptionActive = subscriptionActive;
        }

        public String getSubscriptionType() {
            return subscriptionType;
        }

        public void setSubscriptionType(String subscriptionType) {
            this.subscriptionType = subscriptionType;
        }

        public String[] getPositionTemplateIds() {
            return positionTemplateIds;
        }

        public void setPositionTemplateIds(String[] positionTemplateIds) {
            this.positionTemplateIds = positionTemplateIds;
        }

        public String[] getNoAiPositionTemplateIds() {
            return noAiPositionTemplateIds;
        }

        public void setNoAiPositionTemplateIds(String[] noAiPositionTemplateIds) {
            this.noAiPositionTemplateIds = noAiPositionTemplateIds;
        }

        public String[] getRetouchPositionTemplateIds() {
            return retouchPositionTemplateIds;
        }

        public void setRetouchPositionTemplateIds(String[] retouchPositionTemplateIds) {
            this.retouchPositionTemplateIds = retouchPositionTemplateIds;
        }

        public String[] getSortedPositionTemplateIds() {
            return sortedPositionTemplateIds;
        }

        public void setSortedPositionTemplateIds(String[] sortedPositionTemplateIds) {
            this.sortedPositionTemplateIds = sortedPositionTemplateIds;
        }

        public String[] getUserExportSortIds() {
            return userExportSortIds;
        }

        public void setUserExportSortIds(String[] userExportSortIds) {
            this.userExportSortIds = userExportSortIds;
        }

        public String getExportSortLastUpdate() {
            return exportSortLastUpdate;
        }

        public void setExportSortLastUpdate(String exportSortLastUpdate) {
            this.exportSortLastUpdate = exportSortLastUpdate;
        }

        public UserSettings getSettings() {
            return settings;
        }

        public void setSettings(UserSettings settings) {
            this.settings = settings;
        }

        public String[] getUserPositionTemplates() {
            return userPositionTemplates;
        }

        public void setUserPositionTemplates(String[] userPositionTemplates) {
            this.userPositionTemplates = userPositionTemplates;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }

        public String getWorkingStatus() {
            return workingStatus;
        }

        public void setWorkingStatus(String workingStatus) {
            this.workingStatus = workingStatus;
        }

        public boolean isTrainingRetoucher() {
            return isTrainingRetoucher;
        }

        public void setTrainingRetoucher(boolean trainingRetoucher) {
            isTrainingRetoucher = trainingRetoucher;
        }

        public String getLastActive() {
            return lastActive;
        }

        public void setLastActive(String lastActive) {
            this.lastActive = lastActive;
        }

        public String getLastSubscriptionStartDate() {
            return lastSubscriptionStartDate;
        }

        public void setLastSubscriptionStartDate(String lastSubscriptionStartDate) {
            this.lastSubscriptionStartDate = lastSubscriptionStartDate;
        }

        public String getLastSubscriptionEndDate() {
            return lastSubscriptionEndDate;
        }

        public void setLastSubscriptionEndDate(String lastSubscriptionEndDate) {
            this.lastSubscriptionEndDate = lastSubscriptionEndDate;
        }

        public String[] getSubUsersIds() {
            return subUsersIds;
        }

        public void setSubUsersIds(String[] subUsersIds) {
            this.subUsersIds = subUsersIds;
        }

        public UserVehiclePackage getUserVehiclePackage() {
            return userVehiclePackage;
        }

        public void setUserVehiclePackage(UserVehiclePackage userVehiclePackage) {
            this.userVehiclePackage = userVehiclePackage;
        }

        public int getImgWidth() {
            return imgWidth;
        }

        public void setImgWidth(int imgWidth) {
            this.imgWidth = imgWidth;
        }

        public AdminSettings getAdminSettings() {
            return adminSettings;
        }

        public void setAdminSettings(AdminSettings adminSettings) {
            this.adminSettings = adminSettings;
        }

        public boolean isOrganization() {
            return isOrganization;
        }

        public void setOrganization(boolean organization) {
            isOrganization = organization;
        }

        public String getLoginQrFile() {
            return loginQrFile;
        }

        public void setLoginQrFile(String loginQrFile) {
            this.loginQrFile = loginQrFile;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(String organizationId) {
            this.organizationId = organizationId;
        }

        public String[] getUserPermissions() {
            return userPermissions;
        }

        public void setUserPermissions(String[] userPermissions) {
            this.userPermissions = userPermissions;
        }

        public boolean isOrganizationMailEnabled() {
            return isOrganizationMailEnabled;
        }

        public void setOrganizationMailEnabled(boolean organizationMailEnabled) {
            isOrganizationMailEnabled = organizationMailEnabled;
        }

        public boolean isOrganizationMailCopiedToDealer() {
            return isOrganizationMailCopiedToDealer;
        }

        public void setOrganizationMailCopiedToDealer(boolean organizationMailCopiedToDealer) {
            isOrganizationMailCopiedToDealer = organizationMailCopiedToDealer;
        }

        public String[] getTemplateImagesIds() {
            return templateImagesIds;
        }

        public void setTemplateImagesIds(String[] templateImagesIds) {
            this.templateImagesIds = templateImagesIds;
        }

        public boolean isWorking() {
            return isWorking;
        }

        public void setWorking(boolean working) {
            isWorking = working;
        }



        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class UserSettings {

            @JsonProperty("id")
            public int id;

            @JsonProperty("disable_world_light")
            public boolean disableWorldLight;

            @JsonProperty("disable_car_light")
            public boolean disableCarLight;

            @JsonProperty("padding_factor")
            public String paddingFactor;

            @JsonProperty("shadow_opacity_power_0")
            public String shadowOpacityPower0;

            @JsonProperty("hide_license_plate")
            public boolean hideLicensePlate;

            @JsonProperty("license_plate_logo")
            public String licensePlateLogo;

            @JsonProperty("license_plate_bk_color")
            public String licensePlateBkColor;

            @JsonProperty("body_style")
            public String bodyStyle;

            @JsonProperty("allow_crm_preview")
            public boolean allowCrmPreview;

            @JsonProperty("allow_web_ai_conversion")
            public boolean allowWebAiConversion;

            @JsonProperty("allow_psd_download")
            public boolean allowPsdDownload;

            @JsonProperty("allow_add_vehicles")
            public boolean allowAddVehicles;

            @JsonProperty("is_google_drive_enabled")
            public boolean isGoogleDriveEnabled;

            @JsonProperty("is_ftp_enabled")
            public boolean isFtpEnabled;

            @JsonProperty("ftp_host")
            public String ftpHost;

            @JsonProperty("ftp_username")
            public String ftpUsername;

            @JsonProperty("ftp_dir")
            public String ftpDir;

            @JsonProperty("ftp_webhook_url")
            public String ftpWebhookUrl;

            @JsonProperty("is_ftp_lazy")
            public boolean isFtpLazy;

            @JsonProperty("should_ignore_lazy_ftp_history")
            public boolean shouldIgnoreLazyFtpHistory;

            @JsonProperty("should_ignore_lazy_compressed_ftp_history")
            public boolean shouldIgnoreLazyCompressedFtpHistory;

            @JsonProperty("is_ftp_compressed")
            public boolean isFtpCompressed;

            @JsonProperty("is_ftp_vin_dir_enabled")
            public boolean isFtpVinDirEnabled;

            @JsonProperty("is_ftp_full_vehicle_reupload")
            public boolean isFtpFullVehicleReupload;

            @JsonProperty("is_only_retouched_vehicle_ftp")
            public boolean isOnlyRetouchedVehicleFtp;

            @JsonProperty("is_date_group_dirs_disabled")
            public boolean isDateGroupDirsDisabled;

            @JsonProperty("is_16_orientations_enabled")
            public boolean is16OrientationsEnabled;

            @JsonProperty("date_created")
            public String dateCreated;

            @JsonProperty("date_modified")
            public String dateModified;

            @JsonProperty("allow_position_templates_update")
            public boolean allowPositionTemplatesUpdate;

            @JsonProperty("allow_interior_ai_update")
            public boolean allowInteriorAiUpdate;

            @JsonProperty("is_trial")
            public boolean isTrial;

            @JsonProperty("is_vip")
            public boolean isVip;

            @JsonProperty("img_width")
            public int imgWidth;

            @JsonProperty("is_autorola_enabled")
            public boolean isAutorolaEnabled;

            @JsonProperty("autorola_username")
            public String autorolaUsername;

            @JsonProperty("is_email_notification_enabled")
            public boolean isEmailNotificationEnabled;

            @JsonProperty("notification_emails")
            public String notificationEmails;

            @JsonProperty("is_ftp_status_file_enabled")
            public boolean isFtpStatusFileEnabled;

            @JsonProperty("is_auto_archive_enabled")
            public boolean isAutoArchiveEnabled;

            @JsonProperty("allow_photo_collage")
            public boolean allowPhotoCollage;

            @JsonProperty("photo_collage_banner")
            public String photoCollageBanner;

            @JsonProperty("is_ftp_special_file_enabled")
            public boolean isFtpSpecialFileEnabled;

            // getters and setters

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isDisableWorldLight() {
                return disableWorldLight;
            }

            public void setDisableWorldLight(boolean disableWorldLight) {
                this.disableWorldLight = disableWorldLight;
            }

            public boolean isDisableCarLight() {
                return disableCarLight;
            }

            public void setDisableCarLight(boolean disableCarLight) {
                this.disableCarLight = disableCarLight;
            }

            public String getPaddingFactor() {
                return paddingFactor;
            }

            public void setPaddingFactor(String paddingFactor) {
                this.paddingFactor = paddingFactor;
            }

            public String getShadowOpacityPower0() {
                return shadowOpacityPower0;
            }

            public void setShadowOpacityPower0(String shadowOpacityPower0) {
                this.shadowOpacityPower0 = shadowOpacityPower0;
            }

            public boolean isHideLicensePlate() {
                return hideLicensePlate;
            }

            public void setHideLicensePlate(boolean hideLicensePlate) {
                this.hideLicensePlate = hideLicensePlate;
            }

            public String getLicensePlateLogo() {
                return licensePlateLogo;
            }

            public void setLicensePlateLogo(String licensePlateLogo) {
                this.licensePlateLogo = licensePlateLogo;
            }

            public String getLicensePlateBkColor() {
                return licensePlateBkColor;
            }

            public void setLicensePlateBkColor(String licensePlateBkColor) {
                this.licensePlateBkColor = licensePlateBkColor;
            }

            public String getBodyStyle() {
                return bodyStyle;
            }

            public void setBodyStyle(String bodyStyle) {
                this.bodyStyle = bodyStyle;
            }

            public boolean isAllowCrmPreview() {
                return allowCrmPreview;
            }

            public void setAllowCrmPreview(boolean allowCrmPreview) {
                this.allowCrmPreview = allowCrmPreview;
            }

            public boolean isAllowWebAiConversion() {
                return allowWebAiConversion;
            }

            public void setAllowWebAiConversion(boolean allowWebAiConversion) {
                this.allowWebAiConversion = allowWebAiConversion;
            }

            public boolean isAllowPsdDownload() {
                return allowPsdDownload;
            }

            public void setAllowPsdDownload(boolean allowPsdDownload) {
                this.allowPsdDownload = allowPsdDownload;
            }

            public boolean isAllowAddVehicles() {
                return allowAddVehicles;
            }

            public void setAllowAddVehicles(boolean allowAddVehicles) {
                this.allowAddVehicles = allowAddVehicles;
            }

            public boolean isGoogleDriveEnabled() {
                return isGoogleDriveEnabled;
            }

            public void setGoogleDriveEnabled(boolean googleDriveEnabled) {
                isGoogleDriveEnabled = googleDriveEnabled;
            }

            public boolean isFtpEnabled() {
                return isFtpEnabled;
            }

            public void setFtpEnabled(boolean ftpEnabled) {
                isFtpEnabled = ftpEnabled;
            }

            public String getFtpHost() {
                return ftpHost;
            }

            public void setFtpHost(String ftpHost) {
                this.ftpHost = ftpHost;
            }

            public String getFtpUsername() {
                return ftpUsername;
            }

            public void setFtpUsername(String ftpUsername) {
                this.ftpUsername = ftpUsername;
            }

            public String getFtpDir() {
                return ftpDir;
            }

            public void setFtpDir(String ftpDir) {
                this.ftpDir = ftpDir;
            }

            public String getFtpWebhookUrl() {
                return ftpWebhookUrl;
            }

            public void setFtpWebhookUrl(String ftpWebhookUrl) {
                this.ftpWebhookUrl = ftpWebhookUrl;
            }

            public boolean isFtpLazy() {
                return isFtpLazy;
            }

            public void setFtpLazy(boolean ftpLazy) {
                isFtpLazy = ftpLazy;
            }

            public boolean isShouldIgnoreLazyFtpHistory() {
                return shouldIgnoreLazyFtpHistory;
            }

            public void setShouldIgnoreLazyFtpHistory(boolean shouldIgnoreLazyFtpHistory) {
                this.shouldIgnoreLazyFtpHistory = shouldIgnoreLazyFtpHistory;
            }

            public boolean isShouldIgnoreLazyCompressedFtpHistory() {
                return shouldIgnoreLazyCompressedFtpHistory;
            }

            public void setShouldIgnoreLazyCompressedFtpHistory(boolean shouldIgnoreLazyCompressedFtpHistory) {
                this.shouldIgnoreLazyCompressedFtpHistory = shouldIgnoreLazyCompressedFtpHistory;
            }

            public boolean isFtpCompressed() {
                return isFtpCompressed;
            }

            public void setFtpCompressed(boolean ftpCompressed) {
                isFtpCompressed = ftpCompressed;
            }

            public boolean isFtpVinDirEnabled() {
                return isFtpVinDirEnabled;
            }

            public void setFtpVinDirEnabled(boolean ftpVinDirEnabled) {
                isFtpVinDirEnabled = ftpVinDirEnabled;
            }

            public boolean isFtpFullVehicleReupload() {
                return isFtpFullVehicleReupload;
            }

            public void setFtpFullVehicleReupload(boolean ftpFullVehicleReupload) {
                isFtpFullVehicleReupload = ftpFullVehicleReupload;
            }

            public boolean isOnlyRetouchedVehicleFtp() {
                return isOnlyRetouchedVehicleFtp;
            }

            public void setOnlyRetouchedVehicleFtp(boolean onlyRetouchedVehicleFtp) {
                isOnlyRetouchedVehicleFtp = onlyRetouchedVehicleFtp;
            }

            public boolean isDateGroupDirsDisabled() {
                return isDateGroupDirsDisabled;
            }

            public void setDateGroupDirsDisabled(boolean dateGroupDirsDisabled) {
                isDateGroupDirsDisabled = dateGroupDirsDisabled;
            }

            public boolean isIs16OrientationsEnabled() {
                return is16OrientationsEnabled;
            }

            public void setIs16OrientationsEnabled(boolean is16OrientationsEnabled) {
                this.is16OrientationsEnabled = is16OrientationsEnabled;
            }

            public String getDateCreated() {
                return dateCreated;
            }

            public void setDateCreated(String dateCreated) {
                this.dateCreated = dateCreated;
            }

            public String getDateModified() {
                return dateModified;
            }

            public void setDateModified(String dateModified) {
                this.dateModified = dateModified;
            }

            public boolean isAllowPositionTemplatesUpdate() {
                return allowPositionTemplatesUpdate;
            }

            public void setAllowPositionTemplatesUpdate(boolean allowPositionTemplatesUpdate) {
                this.allowPositionTemplatesUpdate = allowPositionTemplatesUpdate;
            }

            public boolean isAllowInteriorAiUpdate() {
                return allowInteriorAiUpdate;
            }

            public void setAllowInteriorAiUpdate(boolean allowInteriorAiUpdate) {
                this.allowInteriorAiUpdate = allowInteriorAiUpdate;
            }

            public boolean isTrial() {
                return isTrial;
            }

            public void setTrial(boolean trial) {
                isTrial = trial;
            }

            public boolean isVip() {
                return isVip;
            }

            public void setVip(boolean vip) {
                isVip = vip;
            }

            public int getImgWidth() {
                return imgWidth;
            }

            public void setImgWidth(int imgWidth) {
                this.imgWidth = imgWidth;
            }

            public boolean isAutorolaEnabled() {
                return isAutorolaEnabled;
            }

            public void setAutorolaEnabled(boolean autorolaEnabled) {
                isAutorolaEnabled = autorolaEnabled;
            }

            public String getAutorolaUsername() {
                return autorolaUsername;
            }

            public void setAutorolaUsername(String autorolaUsername) {
                this.autorolaUsername = autorolaUsername;
            }

            public boolean isEmailNotificationEnabled() {
                return isEmailNotificationEnabled;
            }

            public void setEmailNotificationEnabled(boolean emailNotificationEnabled) {
                isEmailNotificationEnabled = emailNotificationEnabled;
            }

            public String getNotificationEmails() {
                return notificationEmails;
            }

            public void setNotificationEmails(String notificationEmails) {
                this.notificationEmails = notificationEmails;
            }

            public boolean isFtpStatusFileEnabled() {
                return isFtpStatusFileEnabled;
            }

            public void setFtpStatusFileEnabled(boolean ftpStatusFileEnabled) {
                isFtpStatusFileEnabled = ftpStatusFileEnabled;
            }

            public boolean isAutoArchiveEnabled() {
                return isAutoArchiveEnabled;
            }

            public void setAutoArchiveEnabled(boolean autoArchiveEnabled) {
                isAutoArchiveEnabled = autoArchiveEnabled;
            }

            public boolean isAllowPhotoCollage() {
                return allowPhotoCollage;
            }

            public void setAllowPhotoCollage(boolean allowPhotoCollage) {
                this.allowPhotoCollage = allowPhotoCollage;
            }

            public String getPhotoCollageBanner() {
                return photoCollageBanner;
            }

            public void setPhotoCollageBanner(String photoCollageBanner) {
                this.photoCollageBanner = photoCollageBanner;
            }

            public boolean isFtpSpecialFileEnabled() {
                return isFtpSpecialFileEnabled;
            }

            public void setFtpSpecialFileEnabled(boolean ftpSpecialFileEnabled) {
                isFtpSpecialFileEnabled = ftpSpecialFileEnabled;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class UserVehiclePackage {

            @JsonProperty("id")
            public int id;

            @JsonProperty("vehicle_package")
            public int vehiclePackage;

            @JsonProperty("retouch_package")
            public String retouchPackage;

            @JsonProperty("vehicle_balance")
            public int vehicleBalance;

            @JsonProperty("user_id")
            public int userId;

            @JsonProperty("is_renewable")
            public boolean isRenewable;

            @JsonProperty("date_renewal")
            public String dateRenewal;

            @JsonProperty("date_created")
            public String dateCreated;

            @JsonProperty("date_modified")
            public String dateModified;

            // getters and setters


            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getVehiclePackage() {
                return vehiclePackage;
            }

            public void setVehiclePackage(int vehiclePackage) {
                this.vehiclePackage = vehiclePackage;
            }

            public String getRetouchPackage() {
                return retouchPackage;
            }

            public void setRetouchPackage(String retouchPackage) {
                this.retouchPackage = retouchPackage;
            }

            public int getVehicleBalance() {
                return vehicleBalance;
            }

            public void setVehicleBalance(int vehicleBalance) {
                this.vehicleBalance = vehicleBalance;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public boolean isRenewable() {
                return isRenewable;
            }

            public void setRenewable(boolean renewable) {
                isRenewable = renewable;
            }

            public String getDateRenewal() {
                return dateRenewal;
            }

            public void setDateRenewal(String dateRenewal) {
                this.dateRenewal = dateRenewal;
            }

            public String getDateCreated() {
                return dateCreated;
            }

            public void setDateCreated(String dateCreated) {
                this.dateCreated = dateCreated;
            }

            public String getDateModified() {
                return dateModified;
            }

            public void setDateModified(String dateModified) {
                this.dateModified = dateModified;
            }
        }



        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdminSettings {

            public AdminSettings ( Boolean Training , int Target , String WorkingDays){
            //Constructor for designers working days and target

                this.retouchTargetPerDay = Target ;
                this.reviewTargetPerDay = Target ;
                this.auditTargetPerDay = Target ;
                this.workingDays = WorkingDays;
                this.isTrainingRetoucher = Training ;

            }



            @JsonProperty("id")
            public int id;

            @JsonProperty("user_id")
            public int userId;

            @JsonProperty("retouch_target_per_day")
            public Integer retouchTargetPerDay;

            @JsonProperty("review_target_per_day")
            public Integer reviewTargetPerDay;

            @JsonProperty("audit_target_per_day")
            public Integer auditTargetPerDay;

            @JsonProperty("working_days")
            public String workingDays;

            @JsonProperty("is_retouch_user")
            public boolean isRetouchUser;

            @JsonProperty("is_review_user")
            public boolean isReviewUser;

            @JsonProperty("is_view_vehicle_user")
            public boolean isViewVehicleUser;

            @JsonProperty("is_sales_user")
            public boolean isSalesUser;

            @JsonProperty("is_training_retoucher")
            public boolean isTrainingRetoucher;

            @JsonProperty("is_audit_user")
            public boolean isAuditUser;

            @JsonProperty("is_reported_images_user")
            public boolean isReportedImagesUser;

            @JsonProperty("is_reported_issues_user")
            public boolean isReportedIssuesUser;

            @JsonProperty("is_retoucher_audited_user")
            public boolean isRetoucherAuditedUser;

            @JsonProperty("is_pipedrive_user")
            public boolean isPipedriveUser;

            // getters and setters

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Integer getRetouchTargetPerDay() {
                return retouchTargetPerDay;
            }

            public void setRetouchTargetPerDay(Integer retouchTargetPerDay) {
                this.retouchTargetPerDay = retouchTargetPerDay;
            }

            public Integer getReviewTargetPerDay() {
                return reviewTargetPerDay;
            }

            public void setReviewTargetPerDay(Integer reviewTargetPerDay) {
                this.reviewTargetPerDay = reviewTargetPerDay;
            }

            public Integer getAuditTargetPerDay() {
                return auditTargetPerDay;
            }

            public void setAuditTargetPerDay(Integer auditTargetPerDay) {
                this.auditTargetPerDay = auditTargetPerDay;
            }

            public String getWorkingDays() {
                return workingDays;
            }

            public void setWorkingDays(String workingDays) {
                this.workingDays = workingDays;
            }

            public boolean isRetouchUser() {
                return isRetouchUser;
            }

            public void setRetouchUser(boolean retouchUser) {
                isRetouchUser = retouchUser;
            }

            public boolean isReviewUser() {
                return isReviewUser;
            }

            public void setReviewUser(boolean reviewUser) {
                isReviewUser = reviewUser;
            }

            public boolean isViewVehicleUser() {
                return isViewVehicleUser;
            }

            public void setViewVehicleUser(boolean viewVehicleUser) {
                isViewVehicleUser = viewVehicleUser;
            }

            public boolean isSalesUser() {
                return isSalesUser;
            }

            public void setSalesUser(boolean salesUser) {
                isSalesUser = salesUser;
            }

            public boolean isTrainingRetoucher() {
                return isTrainingRetoucher;
            }

            public void setTrainingRetoucher(boolean trainingRetoucher) {
                isTrainingRetoucher = trainingRetoucher;
            }

            public boolean isAuditUser() {
                return isAuditUser;
            }

            public void setAuditUser(boolean auditUser) {
                isAuditUser = auditUser;
            }

            public boolean isReportedImagesUser() {
                return isReportedImagesUser;
            }

            public void setReportedImagesUser(boolean reportedImagesUser) {
                isReportedImagesUser = reportedImagesUser;
            }

            public boolean isReportedIssuesUser() {
                return isReportedIssuesUser;
            }

            public void setReportedIssuesUser(boolean reportedIssuesUser) {
                isReportedIssuesUser = reportedIssuesUser;
            }

            public boolean isRetoucherAuditedUser() {
                return isRetoucherAuditedUser;
            }

            public void setRetoucherAuditedUser(boolean retoucherAuditedUser) {
                isRetoucherAuditedUser = retoucherAuditedUser;
            }

            public boolean isPipedriveUser() {
                return isPipedriveUser;
            }

            public void setPipedriveUser(boolean pipedriveUser) {
                isPipedriveUser = pipedriveUser;
            }
        }
    }
}



