package autofox.objects.objectSystem.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminUsersPojoChatGBT {
    public AdminUsersPojoChatGBT(String Email , String UserName ){

    }



    @JsonProperty("status")
    private int status;

    @JsonProperty("data")
    private UserData data;

    // getters and setters


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserData {
        public UserData(String Email ,String UserName  ,String FirstName ,String LastName ,String CompanyName ,String CompanyAddress ,String Language , String Country , boolean Permission ){
            this.email = Email;
            this.username = UserName ;
            this.firstName = FirstName;
            this.lastName = LastName;
            this.companyName = CompanyName ;
            this.companyAddress = CompanyAddress ;
            this.language = Language ;
            this.countryId = Country;
        }

        @JsonProperty("id")
        private int id;

        @JsonProperty("email")
        private String email;

        @JsonProperty("username")
        private String username;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("company_name")
        private String companyName;

        @JsonProperty("company_address")
        private String companyAddress;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("postal_code")
        private String postalCode;

        @JsonProperty("region")
        private String region;

        @JsonProperty("language")
        private String language;

        @JsonProperty("date_joined")
        private String dateJoined;

        @JsonProperty("date_deleted")
        private String dateDeleted;

        @JsonProperty("last_login")
        private String lastLogin;

        @JsonProperty("is_superuser")
        private boolean isSuperuser;

        @JsonProperty("is_staff")
        private boolean isStaff;

        @JsonProperty("is_active")
        private boolean isActive;

        @JsonProperty("login_token")
        private String loginToken;

        @JsonProperty("balance")
        private String balance;

        @JsonProperty("vin_query_balance")
        private String vinQueryBalance;

        @JsonProperty("registration_document_balance")
        private String registrationDocumentBalance;

        @JsonProperty("retouch_balance")
        private String retouchBalance;

        @JsonProperty("subscription_start_date")
        private String subscriptionStartDate;

        @JsonProperty("subscription_end_date")
        private String subscriptionEndDate;

        @JsonProperty("is_subscription_active")
        private boolean isSubscriptionActive;

        @JsonProperty("subscription_type")
        private String subscriptionType;

        @JsonProperty("position_template_ids")
        private String[] positionTemplateIds;

        @JsonProperty("no_ai_position_template_ids")
        private String[] noAiPositionTemplateIds;

        @JsonProperty("retouch_position_template_ids")
        private String[] retouchPositionTemplateIds;

        @JsonProperty("sorted_position_template_ids")
        private String[] sortedPositionTemplateIds;

        @JsonProperty("user_export_sort_ids")
        private String[] userExportSortIds;

        @JsonProperty("export_sort_last_update")
        private String exportSortLastUpdate;

        @JsonProperty("settings")
        private UserSettings settings;

        @JsonProperty("user_position_templates")
        private String[] userPositionTemplates;

        @JsonProperty("country_id")
        private String countryId;

        @JsonProperty("working_status")
        private String workingStatus;

        @JsonProperty("is_training_retoucher")
        private boolean isTrainingRetoucher;

        @JsonProperty("last_active")
        private String lastActive;

        @JsonProperty("last_subscription_start_date")
        private String lastSubscriptionStartDate;

        @JsonProperty("last_subscription_end_date")
        private String lastSubscriptionEndDate;

        @JsonProperty("sub_users_ids")
        private String[] subUsersIds;

        @JsonProperty("user_vehicle_package")
        private UserVehiclePackage userVehiclePackage;

        @JsonProperty("img_width")
        private int imgWidth;

        @JsonProperty("admin_settings")
        private AdminSettings adminSettings;

        @JsonProperty("is_organization")
        private boolean isOrganization;

        @JsonProperty("login_qr_file")
        private String loginQrFile;

        @JsonProperty("branch_id")
        private String branchId;

        @JsonProperty("organization_id")
        private String organizationId;

        @JsonProperty("user_permissions")
        private String[] userPermissions;

        @JsonProperty("is_organization_mail_enabled")
        private boolean isOrganizationMailEnabled;

        @JsonProperty("is_organization_mail_copied_to_dealer")
        private boolean isOrganizationMailCopiedToDealer;

        @JsonProperty("template_images_ids")
        private String[] templateImagesIds;

        @JsonProperty("is_working")
        private boolean isWorking;

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
            private int id;

            @JsonProperty("disable_world_light")
            private boolean disableWorldLight;

            @JsonProperty("disable_car_light")
            private boolean disableCarLight;

            @JsonProperty("padding_factor")
            private String paddingFactor;

            @JsonProperty("shadow_opacity_power_0")
            private String shadowOpacityPower0;

            @JsonProperty("hide_license_plate")
            private boolean hideLicensePlate;

            @JsonProperty("license_plate_logo")
            private String licensePlateLogo;

            @JsonProperty("license_plate_bk_color")
            private String licensePlateBkColor;

            @JsonProperty("body_style")
            private String bodyStyle;

            @JsonProperty("allow_crm_preview")
            private boolean allowCrmPreview;

            @JsonProperty("allow_web_ai_conversion")
            private boolean allowWebAiConversion;

            @JsonProperty("allow_psd_download")
            private boolean allowPsdDownload;

            @JsonProperty("allow_add_vehicles")
            private boolean allowAddVehicles;

            @JsonProperty("is_google_drive_enabled")
            private boolean isGoogleDriveEnabled;

            @JsonProperty("is_ftp_enabled")
            private boolean isFtpEnabled;

            @JsonProperty("ftp_host")
            private String ftpHost;

            @JsonProperty("ftp_username")
            private String ftpUsername;

            @JsonProperty("ftp_dir")
            private String ftpDir;

            @JsonProperty("ftp_webhook_url")
            private String ftpWebhookUrl;

            @JsonProperty("is_ftp_lazy")
            private boolean isFtpLazy;

            @JsonProperty("should_ignore_lazy_ftp_history")
            private boolean shouldIgnoreLazyFtpHistory;

            @JsonProperty("should_ignore_lazy_compressed_ftp_history")
            private boolean shouldIgnoreLazyCompressedFtpHistory;

            @JsonProperty("is_ftp_compressed")
            private boolean isFtpCompressed;

            @JsonProperty("is_ftp_vin_dir_enabled")
            private boolean isFtpVinDirEnabled;

            @JsonProperty("is_ftp_full_vehicle_reupload")
            private boolean isFtpFullVehicleReupload;

            @JsonProperty("is_only_retouched_vehicle_ftp")
            private boolean isOnlyRetouchedVehicleFtp;

            @JsonProperty("is_date_group_dirs_disabled")
            private boolean isDateGroupDirsDisabled;

            @JsonProperty("is_16_orientations_enabled")
            private boolean is16OrientationsEnabled;

            @JsonProperty("date_created")
            private String dateCreated;

            @JsonProperty("date_modified")
            private String dateModified;

            @JsonProperty("allow_position_templates_update")
            private boolean allowPositionTemplatesUpdate;

            @JsonProperty("allow_interior_ai_update")
            private boolean allowInteriorAiUpdate;

            @JsonProperty("is_trial")
            private boolean isTrial;

            @JsonProperty("is_vip")
            private boolean isVip;

            @JsonProperty("img_width")
            private int imgWidth;

            @JsonProperty("is_autorola_enabled")
            private boolean isAutorolaEnabled;

            @JsonProperty("autorola_username")
            private String autorolaUsername;

            @JsonProperty("is_email_notification_enabled")
            private boolean isEmailNotificationEnabled;

            @JsonProperty("notification_emails")
            private String notificationEmails;

            @JsonProperty("is_ftp_status_file_enabled")
            private boolean isFtpStatusFileEnabled;

            @JsonProperty("is_auto_archive_enabled")
            private boolean isAutoArchiveEnabled;

            @JsonProperty("allow_photo_collage")
            private boolean allowPhotoCollage;

            @JsonProperty("photo_collage_banner")
            private String photoCollageBanner;

            @JsonProperty("is_ftp_special_file_enabled")
            private boolean isFtpSpecialFileEnabled;

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
            private int id;

            @JsonProperty("vehicle_package")
            private int vehiclePackage;

            @JsonProperty("retouch_package")
            private String retouchPackage;

            @JsonProperty("vehicle_balance")
            private int vehicleBalance;

            @JsonProperty("user_id")
            private int userId;

            @JsonProperty("is_renewable")
            private boolean isRenewable;

            @JsonProperty("date_renewal")
            private String dateRenewal;

            @JsonProperty("date_created")
            private String dateCreated;

            @JsonProperty("date_modified")
            private String dateModified;

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

            @JsonProperty("id")
            private int id;

            @JsonProperty("user_id")
            private int userId;

            @JsonProperty("retouch_target_per_day")
            private Integer retouchTargetPerDay;

            @JsonProperty("review_target_per_day")
            private Integer reviewTargetPerDay;

            @JsonProperty("audit_target_per_day")
            private Integer auditTargetPerDay;

            @JsonProperty("working_days")
            private String workingDays;

            @JsonProperty("is_retouch_user")
            private boolean isRetouchUser;

            @JsonProperty("is_review_user")
            private boolean isReviewUser;

            @JsonProperty("is_view_vehicle_user")
            private boolean isViewVehicleUser;

            @JsonProperty("is_sales_user")
            private boolean isSalesUser;

            @JsonProperty("is_training_retoucher")
            private boolean isTrainingRetoucher;

            @JsonProperty("is_audit_user")
            private boolean isAuditUser;

            @JsonProperty("is_reported_images_user")
            private boolean isReportedImagesUser;

            @JsonProperty("is_reported_issues_user")
            private boolean isReportedIssuesUser;

            @JsonProperty("is_retoucher_audited_user")
            private boolean isRetoucherAuditedUser;

            @JsonProperty("is_pipedrive_user")
            private boolean isPipedriveUser;

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



