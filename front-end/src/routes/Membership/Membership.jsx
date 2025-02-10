/** Code of Membership Page */

import MembershipContainer from "../../components/MembershipContainer/MembershipContainer";
import MembershipHero from "../../components/MembershipHero/MembershipHero";
import MembershipCardContainer from "../../components/MembershipCardContainer/MembershipCardContainer";
import MembershipCard from "../../components/MembershipCard/MembershipCard";

function Membership() {
  return (
    <MembershipContainer>
        <MembershipHero />
        <MembershipCardContainer>
            <MembershipCard 
                title="1 Month"
                description="Full access for 30 days"
                price="200"
            />
            <MembershipCard
                title="3 Months"
                description="Save with a 3-month plan"
                price="80"
            />
            <MembershipCard
                title="4 Months"
                description="Great value for 4 months"
                price="70"
            />
            <MembershipCard
                title="6 Months"
                description="Best savings for 6 months"
                price="50"
            />
            <MembershipCard
                title="1 Year"
                description="Full access for 12 months"
                price="30"
            />
        </MembershipCardContainer>
    </MembershipContainer>
  );
}

export default Membership;
